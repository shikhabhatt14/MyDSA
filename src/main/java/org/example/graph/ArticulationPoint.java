package org.example.graph;

import java.util.ArrayList;

public class ArticulationPoint {

    //articulation point is a vertex which when removed increases the number of connected components in the graph
    //if we remove a vertex and the number of connected components increases then that vertex is an articulation point
    //for example in a tree if we remove the root node then the number of connected components increases
    //if we remove any other node then the number of connected components does not increase

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new ArrayList<>());
        }
       /* // Add edges to the graph (directed graph example)
        DirectedGraph.addEdge(list, 0, 1);
        DirectedGraph.addEdge(list, 1, 4);
        DirectedGraph.addEdge(list, 2, 3);
        DirectedGraph.addEdge(list, 2, 4);
        DirectedGraph.addEdge(list, 3, 4);

        // Print the adjacency list of directed graph
        System.out.println("Adjacency List:");
        DirectedGraph.printGraph(list);*/

        //using undirected graph
        UndirectedGraph.addEdge(list, 0, 1);
        //UndirectedGraph.addEdge(list, 1, 0);
        UndirectedGraph.addEdge(list, 1, 4);
        //UndirectedGraph.addEdge(list, 4, 1);
        UndirectedGraph.addEdge(list, 2, 3);
        //UndirectedGraph.addEdge(list, 3, 2);
        UndirectedGraph.addEdge(list, 2, 4);
        //UndirectedGraph.addEdge(list, 4, 2);
        UndirectedGraph.addEdge(list, 3, 4);
        //UndirectedGraph.addEdge(list, 4, 3);

        // Print the adjacency list
        System.out.println("Adjacency List:");
        UndirectedGraph.printGraph(list);

        // Find articulation points
        boolean[] visited = new boolean[5];
        int[] disc = new int[5];
        int[] low = new int[5];
        boolean[] ap = new boolean[5];

        for(int i=0;i<5;i++){
            if(!visited[i])
                findArticulationPoints(i, -1, 0, visited, disc, low, list, ap);
        }

        System.out.println("Articulation Points:");
        for(int i=0;i<ap.length;i++){
            if(ap[i]){
                System.out.print(i + " ");
            }
        }
    }

    public static void findArticulationPoints(int v, int parent, int time, boolean[] visited, int[] disc, int[] low, ArrayList<ArrayList<Integer>> list, boolean[] ap){
        int children = 0;
        visited[v] = true;
        disc[v] = low[v] = ++time;

        for(int vertex : list.get(v)){
            if(!visited[vertex]){
                children++;
                findArticulationPoints(vertex, v, time, visited, disc, low, list, ap);
                low[v] = Math.min(low[v], low[vertex]);

                if(parent != -1 && low[vertex] >= disc[v])
                    ap[v] = true;
            }else if(vertex != parent){
                low[v] = Math.min(low[v], disc[vertex]);
            }
        }
        if(parent == -1 && children > 1)
            ap[v] = true;
    }

}
