// Java program tod print DFS
// traversal of a given graph.

// Importing necessary 
// modules for Input/Output.
// DFS(visited, u):
//     visited[u]=True
//     Print u
//     for each v in adj[u]:
//         if(visited[v]=False)
//             DFS(visited,v)// psuedo Code

import java.io.*;
import java.util.*;

class DFS {

    // V denotes the number of vertices,
    // adj is the adjacency list of
    // the graph.
    private int V;
    private List<List<Integer>> adj;

    // Constructor
    DFS(int V) {

        // Initializing V
        // and adj.
        this.V = V;
        adj = new ArrayList<>();

        // Inserting V empty lists
        // in the adjacency list.
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    // Function to insert an edge
    // in the graph.
    void insertEdge(int u, int v) {

        // Adding edge from u to v.
        adj.get(u).add(v);
        // Adding edge from v to u.
        adj.get(v).add(u);
    }

    // A helper function for DFS.
    void DFS_helper(int u, boolean visited[]) {
        // Marking u as visited
        visited[u] = true;

        // Printing it's value
        System.out.println(u);

        // Checking for all the
        // nodes adjacent to u.
        for (int v : adj.get(u)) {
            // If any node is not visited
            // till now.
            if (!visited[v]) {
                // Then, call DFS_helper with index
                // as v.
                DFS_helper(v, visited);
            }
        }
    }

    // DFS function
    void DFS(int u) {
        // Declaring a boolean
        // visited array of size V.
        boolean visited[] = new boolean[V];
        // Calling DFS_helper function
        // with index as u.
        DFS_helper(u, visited);
    }

    // Driver Function
    public static void main(String args[]) {
        // Declare an object
        // of graph type.
        DFS g = new DFS(7);
        // Add all the edges through
        // insertEdge function.
        g.insertEdge(0, 1);
        g.insertEdge(0, 3);
        g.insertEdge(1, 4);
        g.insertEdge(1, 2);
        g.insertEdge(2, 3);
        g.insertEdge(4, 5);
        g.insertEdge(4, 6);
        g.insertEdge(5, 6);
        System.out.println("The DFS traversal of the given graph starting from node 0 is -");
        // Call for DFS with
        // index as 0.
        g.DFS(0);
    }
}
