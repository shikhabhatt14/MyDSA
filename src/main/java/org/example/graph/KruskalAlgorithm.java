package org.example.graph;

import java.util.ArrayList;

public class KruskalAlgorithm {

    //Kruskal's algorithm is a greedy algorithm that finds the minimum spanning tree (MST) of a connected, undirected graph.
    // It works by sorting the edges of the graph in non-decreasing order of their weights and adding them to the MST one by one,
    // as long as they do not form a cycle with the edges already included in the MST.
    // The algorithm uses a disjoint-set data structure to keep track of the connected components of the graph.
    // The algorithm can be implemented using a priority queue to sort the edges by weight.
    // The algorithm can be used to find the minimum spanning tree of a connected, undirected graph.

    int[] parent;
    int[] rank;

    public KruskalAlgorithm(int vertices) {
        parent = new int[vertices];
        rank = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]); // Path compression
        }
        return parent[i];
    }

    public void union(int x, int y) {
        int xroot = find(x);
        int yroot = find(y);

        if (xroot != yroot) {
            if (rank[xroot] < rank[yroot]) {
                parent[xroot] = yroot;
            } else if (rank[xroot] > rank[yroot]) {
                parent[yroot] = xroot;
            } else {
                parent[yroot] = xroot;
                rank[xroot]++;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();

        int vCount = 5;

        edges.add(new Edge(0,1, 10));
        edges.add(new Edge(0,2, 8));
        edges.add(new Edge(1,2, 5));
        edges.add(new Edge(1,3, 3));
        edges.add(new Edge(2,3, 4));
        edges.add(new Edge(2, 4, 12));
        edges.add(new Edge(3,4, 15));

        KruskalAlgorithm kruskal = new KruskalAlgorithm(vCount);
        int result = 0;
        // Sort edges by weight
        edges.sort(Edge::compareTo);
         for(int i=0, s=0; s<vCount-1; i++){
             Edge edge = edges.get(i);
             int x = kruskal.find(edge.getSrc());
             int y = kruskal.find(edge.getDest());
             if(x != y){
                 result += edge.getWeight();
                 s++;
                 System.out.println("Edge: " + edge.getSrc() + " - " + edge.getDest() + " Weight: " + edge.getWeight());
                 kruskal.union(x, y);
             }
        }
        System.out.println("Minimum Spanning Tree Weight: " + result);

    }


}
