package org.example.graph;

import java.util.ArrayList;

public class DirectedGraph {

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

        boolean[] visited = new boolean[adjacencyList.size()];
        System.out.println("DFS Traversal:");
        for(int i=0; i<adjacencyList.size(); i++){
            if(!visited[i]){
                System.out.print("DFS starting from vertex " + i + ": ");
                dfs(i, visited, adjacencyList);
                System.out.println();
            }
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int u, int v) {
        adjacencyList.get(u).add(v);
        // No need to add the reverse edge for directed graph
    }

    public static void printGraph(ArrayList<ArrayList<Integer>> adjacencyList) {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print("Vertex " + i + ":");
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(" -> " + neighbor);
            }
            System.out.println();
        }
    }

    public static void dfs(int vertex, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adjacencyList);
            }
        }
    }

}
