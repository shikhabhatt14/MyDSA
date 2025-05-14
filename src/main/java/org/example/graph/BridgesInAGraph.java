package org.example.graph;

import java.util.ArrayList;

public class BridgesInAGraph {

    // A bridge is an edge in a graph whose removal increases the number of connected components in the graph
    // For example in a tree if we remove any edge then the number of connected components increases
    // if we remove any other edge then the number of connected components does not increase

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new ArrayList<>());
        }
        //using undirected graph
        UndirectedGraph.addEdge(list, 0, 1);
        UndirectedGraph.addEdge(list, 1, 4);
        UndirectedGraph.addEdge(list, 2, 3);
        UndirectedGraph.addEdge(list, 2, 4);
        UndirectedGraph.addEdge(list, 3, 4);

        // Print the adjacency list
        System.out.println("Adjacency List:");
        UndirectedGraph.printGraph(list);

        // Find bridges
        boolean[] visited = new boolean[5];
        int[] disc = new int[5];
        int[] low = new int[5];
        ArrayList<Edge> bridges = new ArrayList<>();

        for(int i=0;i<5;i++){
            if(!visited[i])
                findBridges(i, -1, 0, visited, disc, low, list, bridges);
        }

        System.out.println("Bridges:");
        for(Edge edge : bridges){
                System.out.print(edge.getSrc() + " " + edge.getDest() + " ");
        }
    }

    public static void  findBridges(int u, int parent, int time, boolean[] visited, int[] disc, int[] low, ArrayList<ArrayList<Integer>> list, ArrayList<Edge> bridges){
    visited[u] = true;
    disc[u] = low[u] = ++time;
    for(int v : list.get(u)){
        if(v == parent)
            continue;
        if(!visited[v]){
            findBridges(v, u, time, visited, disc, low, list, bridges);
            low[u] = Math.min(low[u], low[v]);
            if(low[v] > disc[u]){
                bridges.add(new Edge(u,v,1));
            }
        }
        else
            low[u] = Math.min(low[u], disc[v]);
    }
    }

}
