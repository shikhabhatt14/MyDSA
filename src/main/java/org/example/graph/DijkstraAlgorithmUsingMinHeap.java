package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithmUsingMinHeap {

    public static void main(String[] args) {
        ArrayList<ArrayList<GraphNode>> graph = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new GraphNode(1, 7));
        graph.get(0).add(new GraphNode(2, 9));
        graph.get(0).add(new GraphNode(5, 14));
        graph.get(1).add(new GraphNode(0, 7));
        graph.get(1).add(new GraphNode(2, 10));
        graph.get(1).add(new GraphNode(3, 15));
        graph.get(2).add(new GraphNode(0, 9));
        graph.get(2).add(new GraphNode(1, 10));
        graph.get(2).add(new GraphNode(3, 11));
        graph.get(2).add(new GraphNode(5, 2));
        graph.get(3).add(new GraphNode(1, 15));
        graph.get(3).add(new GraphNode(2, 11));
        graph.get(3).add(new GraphNode(4, 6));
        graph.get(4).add(new GraphNode(3, 6));
        graph.get(4).add(new GraphNode(5, 9));
        graph.get(5).add(new GraphNode(0, 14));
        graph.get(5).add(new GraphNode(2, 2));
        graph.get(5).add(new GraphNode(4, 9));
        // Dijkstra's algorithm to find the shortest distance from a source node to all other nodes in a graph

        dijkstra(graph, 0);
    }

    public static void dijkstra(ArrayList<ArrayList<GraphNode>> graph, int source){
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // Starting vertex

        PriorityQueue<GraphNode> pq = new PriorityQueue<>((v1, v2) -> v1.getWeight() - v2.getWeight());
        pq.add(new GraphNode(source, 0));

        while(!pq.isEmpty()){
            GraphNode currNode = pq.poll();

            for(GraphNode n : graph.get(currNode.getVertex())){
                if(dist[n.getVertex()] > dist[currNode.getVertex()] + n.getWeight()){
                    dist[n.getVertex()] = dist[currNode.getVertex()] + n.getWeight();
                    pq.add(new GraphNode(n.getVertex(), dist[n.getVertex()]));
                }
            }
        }
        System.out.println("Shortest distance from source to all nodes:");
        for(int i=0;i<dist.length;i++){
            System.out.println("Node " + i + ": " + dist[i]);
        }
    }
}
