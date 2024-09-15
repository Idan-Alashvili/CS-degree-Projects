//Idan Alashvili ID:326117629, Shaked Cohen ID:315327619, Matan Mezamer Tov ID:208414516
#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <queue>
#include <unordered_map>
#include <unordered_set>//For BFS
#include <thread>
#include <netinet/in.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <cstring>
#include <errno.h>
#include <list> 

using namespace std;

class Graph {
private:
    unordered_map<int, vector<int>> adjList;

public:
    void addEdge(int u, int v) {
        adjList[u].push_back(v);
        adjList[v].push_back(u);
    }

    vector<int>& getNeighbors(int u) {
        return adjList[u];
    }
};

Graph graph;
unordered_map<string, vector<int>> cache; // Cache for storing recent requests and responses
list<string> insertionOrder; // List to maintain insertion order

vector<int> breadthFirstSearch(int start, int goal) {
    queue<pair<int, vector<int>>> Queue;
    unordered_set<int> visited;
    Queue.push({start, {start}});
    visited.insert(start);
    while (!Queue.empty()) {
        auto front = Queue.front();
        int node = front.first;
        vector<int> path = front.second;
        Queue.pop();
        if (node == goal) {
            return path;
        }
        for (int child : graph.getNeighbors(node)) {
            if (visited.find(child) == visited.end()) {
                visited.insert(child);
                path.push_back(child);
                Queue.push({child, path});
                path.pop_back();
            }
        }
    }
    cout << "Goal not found" << endl;
    return {}; // Return an empty vector if the goal is not found
}

void handleClient(int clientSocket) {
    char buffer[1024];
    int bytesReceived = recv(clientSocket, buffer, sizeof(buffer), 0);
    if (bytesReceived <= 0) {
        cerr << "Error: Failed to receive data from client." << endl;
        close(clientSocket);
        return;
    }

    buffer[bytesReceived] = '\0';
    stringstream ss(buffer);
    int start, goal;
    ss >> start >> goal;
    string requestKey = to_string(start) + "," + to_string(goal);

    // Check if the request is in the cache
    if (cache.find(requestKey) != cache.end()) {
        cout << "Cache used, request - (" << start << "," << goal << ") was found in the cache." << endl; 
        // Print message indicating cache usage
        vector<int> cachedResponse = cache[requestKey];
        stringstream response;
        for (int node : cachedResponse) {
            response << node << " ";
        }
        response << endl;
        string responseData = response.str();
        send(clientSocket, responseData.c_str(), responseData.size(), 0);
        close(clientSocket);
        return;
    }
    
    // If the cache size exceeds 10, remove the oldest entry
    if (cache.size() > 9) {
        string oldestKey = insertionOrder.front(); // Updated here
        insertionOrder.pop_front();
        cache.erase(oldestKey);
        cout << "Oldest cache entry removed (" << oldestKey << ")." << endl;
    }

    // Perform BFS if request not found in cache
    vector<int> shortestPath = breadthFirstSearch(start, goal);
       
    // If the BFS result is empty, the goal was not found
    if (shortestPath.empty()) {
        send(clientSocket, "", 0, 0); // Send an empty response
        close(clientSocket);
        return;
    }

    // Update cache
    cache[requestKey] = shortestPath;
    insertionOrder.push_back(requestKey);

    // Print the content of the cache
    cout << endl << "Current cache content:" << endl;
    for (const auto& key : insertionOrder) {
        cout << "(" << key << ")" << ": ";
        for (int node : cache[key]) {
            cout << node << " ";
        }
        cout << endl;
    }

    stringstream response;
    for (int node : shortestPath) {
        response << node << " ";
    }
    response << endl;
    string responseData = response.str();
    send(clientSocket, responseData.c_str(), responseData.size(), 0);
    close(clientSocket);
}

void listenOnPort(int portNumber) {
    int serverSocket = socket(AF_INET, SOCK_STREAM, 0);
    if (serverSocket == -1) {
        cerr << "Error: Failed to create socket. " << strerror(errno) << endl;
        return;
    }

    struct sockaddr_in serverAddr; 
    serverAddr.sin_family = AF_INET; // IPv4
    serverAddr.sin_port = htons(portNumber); // converts port number to network byte order
    serverAddr.sin_addr.s_addr = INADDR_ANY; // allows connections from any IP address

    if (bind(serverSocket, (struct sockaddr*)&serverAddr, sizeof(serverAddr)) == -1) {
        cerr << "Error: Bind failed. " << strerror(errno) << endl;
        close(serverSocket);
        return;
    }

    if (listen(serverSocket, 5) == -1) {
        cerr << "Error: Listen failed. " << strerror(errno) << endl;
        close(serverSocket);
        return;
    }

    cout << "Server listening on port " << portNumber << "." << endl;

    while (true) { // Accept clinet connections in an infinite loop (using threads)
        struct sockaddr_in clientAddr; 
        socklen_t clientAddrLen = sizeof(clientAddr);
        int clientSocket = accept(serverSocket, (struct sockaddr*)&clientAddr, &clientAddrLen);
        if (clientSocket == -1) {  //if the creation of new socket went wrong
            cerr << "Error: Accept failed. " << strerror(errno) << endl; 
            close(serverSocket);
            return;
        }
        thread clientThread(handleClient, clientSocket); // Opens a thread to handle the client connection
        clientThread.detach(); // Allows us to communicate with multiple clients, every client uses it's own thread.
    }
    close(serverSocket);
}

int main(int argc, char *argv[]) {
    if (argc != 3) {
        cerr << "Usage: " << argv[0] << " <filename> <port>" << endl;
        return 1;
    }

    string filename = argv[1];
    int portNumber = stoi(argv[2]);

    ifstream file(filename);
    if (!file.is_open()) {
        cerr << "Error: Unable to open file " << filename << "." << endl;
        return 1;
    }

    string line;
    while (getline(file, line)) {
        stringstream ss(line);
        int u, v;
        if (ss >> u >> v) {
            graph.addEdge(u, v);
        } else {
            cerr << "Error: Invalid line in file " << filename << ": " << line << endl;
        }
        ss.clear();
    }

    file.close();
    listenOnPort(portNumber);

    return 0;
}