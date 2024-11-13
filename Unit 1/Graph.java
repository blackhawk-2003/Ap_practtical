// Create a Queue (say Q)
// Mark Vertex V as Visited.
// Put V into the Queue

// While Q is not empty
// 	Remove the head of Q (Let it be Vertex U)
// 	Iterate all Unvisited Neighbours of U 
// 		Mark the neighbour as Visited
// 		Enqueue the Neighbour into Q. #Psuedo code

import java.util.*;

// This class represents an undirected graph using adjacency list representation
class Graph {
    private int numberOfVertices;
    private LinkedList<Integer> adjacencyList[];

    Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjacencyList = new LinkedList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; ++i)
            adjacencyList[i] = new LinkedList<>();
    }

    void addEdge(int from, int to) {
        adjacencyList[from].add(to);
        adjacencyList[to].add(from);
    }

    void bfsTraversal(int vertex) {
        // Mark all the vertices as UNVISITED (By default set as false).
        boolean[] visited = new boolean[numberOfVertices];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        visited[vertex] = true;
        queue.add(vertex);

        while (!queue.isEmpty()) {
            vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int n : adjacencyList[vertex]) {
                if (!visited[n]) {
                    // If an adjacent Vertex has not been visited, then mark it visited and enqueue
                    // it
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        Graph graph = new Graph(7);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);

        System.out.println("Breadth First Traversal from 1 is:");

        graph.bfsTraversal(1);
    }
}
