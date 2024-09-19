//Idan Alashvili
#include <string>
#include <sstream>
#include <cstring>
#include <cerrno>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>

void connectToServer(const std::string& ip, int port, int v1, int v2) { // Allows the client to connect with the server
    int clientSocket = socket(AF_INET, SOCK_STREAM, 0); // create socket using IPv4 (IF_INET) and TCP (SOCK_STREAM)
    if (clientSocket == -1) {
        std::cerr << "Error: Failed to create socket. " << strerror(errno) << std::endl;
        return;
    }
    struct sockaddr_in serverAddr; 
    serverAddr.sin_family = AF_INET; // IPv4
    serverAddr.sin_port = htons(port); // converts port number to network byte order
    if (inet_pton(AF_INET, ip.c_str(), &serverAddr.sin_addr) <= 0) {
        std::cerr << "Error: Invalid IP address. " << strerror(errno) << std::endl;
        close(clientSocket);
        return;
    }
    if (connect(clientSocket, (struct sockaddr*)&serverAddr, sizeof(serverAddr)) == -1) {
        std::cerr << "Error: Connect failed. " << strerror(errno) << std::endl;
        close(clientSocket);
        return;
    }
    std::stringstream request; // create a string stream to foramt the request to the server
    request << v1 << " " << v2 << std::endl; 
    std::string requestData = request.str(); // convert the request stream to a string
    send(clientSocket, requestData.c_str(), requestData.size(), 0); // sends the requset string to the server
    
    // Receive response
    std::stringstream response;
    char buffer[1024]; 
    int bytesReceived;
    while ((bytesReceived = recv(clientSocket, buffer, sizeof(buffer), 0)) > 0) {
        response.write(buffer, bytesReceived);
    }
    if (bytesReceived == -1) {
        std::cerr << "Error: Failed to receive data from server." << std::endl;
        close(clientSocket);
        return;
    }
    
    if (response.str().empty()) {
        std::cout << "Requested goal not found." << std::endl;
    } else {
        std::cout << "Shortest path: " << response.str() << std::endl;
    }
    close(clientSocket);
}

int main(int argc, char *argv[]) {
    if (argc < 5) {
        std::cerr << "Usage: " << argv[0] << " <ip> <port> <v1> <v2>" << std::endl;
        return 1;
    }

    std::string ip = argv[1];
    int port = std::stoi(argv[2]);
    int v1 = std::stoi(argv[3]);
    int v2 = std::stoi(argv[4]);
    connectToServer(ip, port, v1, v2);
    return 0;
}
