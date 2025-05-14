package org.example.graph;

import java.util.Arrays;

public class DijkstraAlgorithmToFindShortestDistanceToAllNodes {

    //dijkstra algorithm to find the shortest distance from a source node to all other nodes in a graph
    //this implementation uses an adjacency matrix to represent the graph
    //the graph is represented as a 2D array where graph[i][j] is the weight of the edge from node i to node j
    //it uses greedy approach to find the shortest distance from the source node to all other nodes
    //the time complexity of this algorithm is O(V^2) where V is the number of vertices in the graph
    //the space complexity of this algorithm is O(V) where V is the number of vertices in the graph
    //time complexity can be reduced to O(E log V) using a priority queue
    //limitations of this algorithm are:
    //1. it can only be used for graphs with non-negative edge weights
    //2. it can only be used for connected graphs

    //it can be applied to both directed and undirected graphs

    public static void main(String[] args) {
        int[][] graph = {
                {0, 7, 9, 0, 0, 14},
                {7, 0, 10, 15, 0, 0},
                {9, 10, 0, 11, 0, 2},
                {0, 15, 11, 0, 6, 0},
                {0, 0, 0, 6, 0, 9},
                {14, 0, 2, 0, 9, 0}
        };

        dijkstra(graph);
    }

    public static void dijkstra(int[][] graph){

        int vCount = graph.length;
        int[] dist = new int[vCount];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[vCount];
        dist[0] = 0; // Starting vertex
        for(int i=0;i<vCount;i++){
            for(int j = i+1;j<vCount;j++){
                if(!visited[i] && graph[i][j] !=0)
                    dist[j] = Math.min(dist[j],dist[i]+graph[i][j]);
            }

        }

        System.out.println("Shortest distance from source to all nodes:");
        for(int i=0;i<vCount;i++){
            System.out.println("Node " + i + ": " + dist[i]);
        }

    }

}
