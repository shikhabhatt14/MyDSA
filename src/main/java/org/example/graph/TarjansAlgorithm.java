package org.example.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class TarjansAlgorithm {

    //Tarjan's algorithm is used to find strongly connected components in a directed graph.
    // It uses depth-first search (DFS) and maintains a stack to keep track of the nodes in the current path.
    // The algorithm also maintains a low-link value for each node, which is the smallest index of any node reachable from that node.
    // If the low-link value of a node is equal to its discovery time, it means that the node is the root of a strongly connected component.
    // The algorithm can be used to find bridges in an undirected graph as well.
    // A bridge is an edge in an undirected graph whose removal increases the number of connected components.
    // The algorithm can be implemented using a stack to keep track of the nodes in the current path.
    // The algorithm can be used to find strongly connected components in a directed graph.

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
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<5;i++){
            if(!visited[i])
                findConnectedComponents(i, -1, 0, visited, disc, low, list, stack);
        }
    }

    public static void findConnectedComponents(int u, int parent, int time, boolean[] visited, int[] disc, int[] low, ArrayList<ArrayList<Integer>> list, Stack<Integer> stack){
        visited[u] = true;
        disc[u] = low[u] = ++time;
        stack.push(u);

        for(int v : list.get(u)){
            if(!visited[v]){
                findConnectedComponents(v, u, time, visited, disc, low, list, stack);
                low[u] = Math.min(low[u], low[v]);
            }
            else if(v != parent){
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        if(low[u] == disc[u]){
            System.out.print("Connected Component: ");
            while(stack.peek() != u){
                System.out.print(stack.pop() + " ");
            }
            System.out.print(stack.pop() + " ");
            System.out.println();
        }
    }

}