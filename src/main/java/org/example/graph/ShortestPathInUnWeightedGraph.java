package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUnWeightedGraph {

    public static void main(String[] args) {
        int vertexCount = 8; // Number of vertices in the graph
        boolean[] visited = new boolean[vertexCount];
        int[] distance = new int[vertexCount];
        // Initialize distance array to -1 (indicating unvisited)
        Arrays.fill(distance, -1);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            list.add(new ArrayList<>());
        }

        // Add edges to the graph (undirected graph example)
        UndirectedGraph.addEdge(list, 0, 1);
        UndirectedGraph.addEdge(list, 0, 4);
        UndirectedGraph.addEdge(list, 1, 2);
        UndirectedGraph.addEdge(list, 1, 3);
        UndirectedGraph.addEdge(list, 1, 4);
        UndirectedGraph.addEdge(list, 2, 3);
        UndirectedGraph.addEdge(list, 3, 4);

        UndirectedGraph.addEdge(list, 5, 6);
        UndirectedGraph.addEdge(list, 5, 7);

        // Print the adjacency list
        //UnDirectedGraphBasicOperations.printGraph(list);

        //shortest path to each node from source node
        int source = 0;
        pathUsingBfs(list, source, visited, distance);
        // Perform BFS starting from vertex 0

        //System.out.println();
        System.out.println("Distance from source node "+ source +" :");
        for(int i=0; i < distance.length; i++){
            System.out.print(distance[i] + " ");
        }
        System.out.println();
        //System.out.println("Distance of " + curr + " from " + source + " is " + distance[curr]);
    }

    public static void pathUsingBfs(ArrayList<ArrayList<Integer>> list, int source, boolean[] visited, int[] distance){
        visited[source] = true;
        distance[source] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int i = 0; i < list.get(curr).size(); i++){
                int neighbor = (int) list.get(curr).get(i);
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    distance[neighbor] = distance[curr] + 1;
                    queue.add(neighbor);
                }
            }
        }

    }

}
