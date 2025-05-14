package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellManFordAlgoToFindShortestDistanceWithNegativeWeight {

    // Bellman-Ford algorithm to find the shortest distance from a source node to all other nodes in a graph
    // This implementation uses an adjacency matrix to represent the graph
    // The graph is represented as a 2D array where graph[i][j] is the weight of the edge from node i to node j
    // It can handle graphs with negative weight edges
    // The time complexity of this algorithm is O(V * E) where V is the number of vertices and E is the number of edges in the graph

    public static void main(String[] args) {

        // Example graph with negative weight edges
        int[][] graphWithNegativeWeight = {
                {0, 1, 4, 0, 0},
                {0, 0, 3, 2, 0},
                {0, 0, 0, -1, 2},
                {0, 0, 0, 0, -2},
                {0, 0, 0, 0, 0}
        };

        int vCount = 5;
        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0,1, 1));
        edges.add(new Edge(0,2, 4));
        edges.add(new Edge(1,2, 3));
        edges.add(new Edge(1,3, 2));
        edges.add(new Edge(2,3, -1));
        edges.add(new Edge(2, 4, 2));
        edges.add(new Edge(3,4, -2));
        // Uncomment the following line to test the graph with negative weights
        //edges.add(new Edge(4,2, 2));
        bellmanFordShortestPath(edges, vCount, 0);
    }

    public static void bellmanFordShortestPath(ArrayList<Edge> edges, int vCount, int src){
        int[] dist = new int[vCount];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; // Starting vertex

        for(int i=0; i<vCount; i++){
            for(Edge edge : edges){
                    dist[edge.getDest()] = Math.min(dist[edge.getDest()],dist[edge.getSrc()]+edge.getWeight());

            }

            //check for negative weight cycle
            for(Edge edge : edges){
                    if(dist[edge.getDest()] > dist[edge.getSrc()]+edge.getWeight()){
                        System.out.println("Negative weight cycle detected");
                        return;
                    }

            }
        }

        System.out.println("Shortest distance from source to all nodes:");
        for(int i=0;i<vCount;i++){
            System.out.println("Node " + i + ": " + dist[i]);
        }


    }

}
