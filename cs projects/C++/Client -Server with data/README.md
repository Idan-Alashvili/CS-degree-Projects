# Consumer-Producer Pathfinding Project

### Course: מבוא לתכנות מערכות
### Project Grade: 100
### Author: Idan Alashvili

## Project Overview

This project implements a multithreaded **Consumer-Producer** model where a client sends requests to a server to find the shortest path between two points in a graph. The graph is built from a large dataset (`db.csv`) containing over 170,000 paths, represented as edges between two nodes.

The server processes these requests and responds with the shortest path between the two nodes using a Breadth-First Search (BFS) algorithm. The system also implements a cache mechanism to store recent paths and optimize performance by avoiding redundant calculations for frequently requested paths.

### Key Features:
- **Client-Server Architecture**: The client connects to the server using a TCP socket and sends a start and goal node. The server processes the request and returns the shortest path between the nodes.
- **Breadth-First Search (BFS)**: The server uses the BFS algorithm to compute the shortest path between two nodes in an undirected graph.
- **Caching**: The server maintains a cache for the 10 most recent path requests, reducing the time needed for repeated requests.
- **Multithreading**: The server can handle multiple clients simultaneously, with each client served by a dedicated thread.
  
## Files
- **Client**: `client.cpp`
  - The client program that connects to the server, sends a request, and receives the shortest path response.
  
- **Server**: `server.cpp`
  - The server program that listens for client connections, processes pathfinding requests, and returns results.

- **Database**: `db.csv`
  - A CSV file containing over 170,000 paths, represented as edges between nodes. Each line contains two integers representing a pair of connected nodes.

## How It Works

### Client:
1. The client connects to the server by specifying an IP address and port.
2. It sends two numbers (representing the start and goal nodes) to the server.
3. The client receives the shortest path from the server and displays it. If the path is not found, the client prints an appropriate message.

### Server:
1. The server loads the graph from the `db.csv` file, representing connections between nodes.
2. When a client connects, the server receives the start and goal nodes, checks the cache for a previously calculated path, or computes the shortest path using BFS if not found in the cache.
3. The server stores the result in the cache and returns it to the client.

### Cache Mechanism:
- The server maintains a cache that stores the last 10 requested paths.
- If a path request is found in the cache, the server immediately responds without recalculating.
- When the cache exceeds 10 entries, the oldest entry is removed to make room for new requests.

## Usage

### Running the Server:
1. Compile the server code:
   ```bash
   g++ -o server server.cpp
2. Run the server with the CSV file and port number:
   ```bash
   ./server db.csv 8080
### Running the Client:
1. Compile the client code:
   ```bash
   g++ -o client client.cpp
2. Run the client with the server's IP address, port number, and the start/goal nodes:
   ```bash
   ./client 127.0.0.1 8080 56 9999
In this example, the client requests the shortest path between nodes 56 and 9999.
Example Output:
Client Request: Start node: 56, Goal node: 9999
Server Response: Shortest path: 56 -> 9999
