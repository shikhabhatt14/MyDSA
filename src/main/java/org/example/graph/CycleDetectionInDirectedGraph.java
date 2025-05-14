package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class CycleDetectionInDirectedGraph {

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
        DirectedGraph.addEdge(list, 0, 1);
        DirectedGraph.addEdge(list, 0, 4);
        DirectedGraph.addEdge(list, 1, 2);
        //DirectedGraph.addEdge(list, 1, 3);
        //DirectedGraph.addEdge(list, 1, 4);
        DirectedGraph.addEdge(list, 2, 3);
        DirectedGraph.addEdge(list, 3, 0);

        DirectedGraph.addEdge(list, 5, 6);
        DirectedGraph.addEdge(list, 5, 7);

        // Print the adjacency list
        DirectedGraph.printGraph(list);
        // Perform DFS starting from vertex 0

        //check for disconnected graph
        boolean isCycle = false;
        for(int i = 0; i < vertexCount; i++){
            if(!visited[i]){
                isCycle = detectCycleUsingDFS(list, visited, i);
                if(isCycle){
                    System.out.println("Cycle detected in the graph.");
                    break;
                }
            }
        }
    }

    public static boolean detectCycleUsingDFS(ArrayList<ArrayList<Integer>> list, boolean[] visited, int curr){

        visited[curr] = true;
        ArrayList<Integer> neighbors = list.get(curr);
        for(int neighbor : neighbors){
            if(visited[neighbor])
                return true;
            else{
                if(detectCycleUsingDFS(list, visited, neighbor))
                    return true;
            }
        }
        return false;
    }

}
