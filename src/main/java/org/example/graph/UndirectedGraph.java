package org.example.graph;

import java.util.ArrayList;

public class UndirectedGraph {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Add edges to the graph (undirected graph example)
        addEdge(adjacencyList, 0, 1);
        addEdge(adjacencyList, 0, 4);
        addEdge(adjacencyList, 1, 2);
        addEdge(adjacencyList, 1, 3);
        addEdge(adjacencyList, 1, 4);
        addEdge(adjacencyList, 2, 3);
        addEdge(adjacencyList, 3, 4);


        // Print the adjacency list
        printGraph(adjacencyList);
    }

    // Method to add an edge to the graph
    public static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u); // For undirected graph
    }

    // Method to print the adjacency list
    public static void printGraph(ArrayList<ArrayList<Integer>> adjacencyList) {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print("Vertex " + i + ":");
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(" -> " + neighbor);
            }
            System.out.println();
        }
    }

}
