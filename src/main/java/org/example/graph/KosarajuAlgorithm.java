package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class KosarajuAlgorithm {

    // Kosaraju's algorithm is used to find strongly connected components (SCCs) in a directed graph.
    // It consists of three main steps:
    // 1. Perform a depth-first search (DFS) on the original graph and store the vertices in a stack based on their finishing times.
    // 2. Transpose the graph (reverse the direction of all edges).
    // 3. Perform DFS on the transposed graph in the order defined by the stack from step 1.
    // Each DFS call will give one strongly connected component.
    // The algorithm is efficient and works in O(V + E) time, where V is the number of vertices and E is the number of edges.
    // The algorithm can be used to find strongly connected components in a directed graph.

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Add edges to the graph (undirected graph example)
        DirectedGraph.addEdge(adjacencyList, 0, 1);
        DirectedGraph.addEdge(adjacencyList, 1, 2);
        DirectedGraph.addEdge(adjacencyList, 2, 0);
        DirectedGraph.addEdge(adjacencyList, 1, 3);
        DirectedGraph.addEdge(adjacencyList, 3, 4);

        // Print the adjacency list
        DirectedGraph.printGraph(adjacencyList);

        //Step 1: Perform DFS and fill the stack
        boolean[] visited = new boolean[adjacencyList.size()];
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < adjacencyList.size(); i++) {
            if (!visited[i]) {
                dfsRec(i, visited, adjacencyList, stack);
                while (!stack.isEmpty()) {
                    result.add(stack.pop());
                }
            }
        }
        System.out.println("DFS order: " + result);

        //Step 2: Transpose the graph
        ArrayList<ArrayList<Integer>> transposedGraph = new ArrayList<>();
        transposeGraph(adjacencyList, transposedGraph);

        //Step 3: Perform DFS on the transposed graph
        Arrays.fill(visited, false);
        for(int i = 0; i < transposedGraph.size(); i++) {
            if (!visited[i]) {
                dfsRec(i, visited, transposedGraph, stack);
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop()+" ");
                }
            }
        }

    }

    public static void dfsRec(int vertex, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList, Stack<Integer> stack) {
        visited[vertex] = true;
        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                dfsRec(neighbor, visited, adjacencyList, stack);
            }
        }
        stack.push(vertex);
    }

    public static void transposeGraph(ArrayList<ArrayList<Integer>> list, ArrayList<ArrayList<Integer>> transposedGraph){
        for (int i = 0; i < list.size(); i++) {
            transposedGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j : list.get(i)) {
                transposedGraph.get(j).add(i);
            }
        }
    }

}
