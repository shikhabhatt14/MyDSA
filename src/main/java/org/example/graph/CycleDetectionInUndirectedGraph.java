package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class CycleDetectionInUndirectedGraph {
    // This class implements the cycle detection algorithm for undirected graphs
    // using a DFS approach. It checks if there is a cycle in the graph.
    // Applications of cycle detection include:
    // 1. Detecting cycles in a directed graph (using DFS).
    // 2. Detecting cycles in an undirected graph (using DFS).
    // 3. Detecting cycles in a directed acyclic graph (DAG).
    // 4. Detecting cycles in a flow network.
    // 5. Detecting cycles in a tree.
    // 6. Detecting cycles in a linked list.
    // 7. Detecting cycles in a maze or grid.

    public static void main(String[] args) {
        int vertexCount = 8; // Number of vertices in the graph
        boolean[] visited = new boolean[vertexCount];
        // Initialize visited array to false
        Arrays.fill(visited, false);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            list.add(new ArrayList<>());
        }

        // Add edges to the graph (undirected graph example)
        UndirectedGraph.addEdge(list, 0, 1);
        UndirectedGraph.addEdge(list, 0, 4);
        UndirectedGraph.addEdge(list, 1, 2);
        //UnDirectedGraphBasicOperations.addEdge(list, 1, 3);
        //UnDirectedGraphBasicOperations.addEdge(list, 1, 4);
        UndirectedGraph.addEdge(list, 2, 3);
        //UnDirectedGraphBasicOperations.addEdge(list, 3, 4);

        UndirectedGraph.addEdge(list, 5, 6);
        UndirectedGraph.addEdge(list, 5, 7);

        // Print the adjacency list
        UndirectedGraph.printGraph(list);
        // Perform DFS starting from vertex 0

        //check for disconnected graph
        boolean isCycle = false;
        for(int i = 0; i < vertexCount; i++){
            if(!visited[i]){
                isCycle = detectCycleUsingDFS(list, visited, i, -1);
                if(isCycle){
                    System.out.println("Cycle detected in the graph.");
                    break;
                }
            }
        }
    }

    public static boolean detectCycleUsingDFS(ArrayList<ArrayList<Integer>> list, boolean[] visited, int curr, int parent){

        visited[curr] = true;
        ArrayList<Integer> neighbors = list.get(curr);
        for(int neighbor : neighbors){
            if(!visited[neighbor]) {
                if(detectCycleUsingDFS(list, visited, neighbor, curr))
                    return true;
            } else if(neighbor != parent)
                return true; // Cycle detected
        }
        return false;
    }
}
