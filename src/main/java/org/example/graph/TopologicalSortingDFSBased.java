package org.example.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortingDFSBased {

    // topological sort using DFS
    // This algorithm is used to find the topological ordering of a directed acyclic graph (DAG).
    // A topological ordering of a directed graph is a linear ordering of its vertices such that for every directed edge u -> v,
    // vertex u comes before vertex v in the ordering.
    // This algorithm uses depth-first search (DFS) to explore the graph and maintain a stack to store the vertices in topological order.
    // The algorithm works as follows:
    // 1. Initialize a visited array to keep track of visited vertices.
    // 2. For each unvisited vertex, perform a DFS traversal.
    // 3. During the DFS traversal, push the vertex onto a stack after visiting all its neighbors.
    // 4. After the DFS traversal is complete, pop the vertices from the stack to get the topological order.
    // 5. The topological order is printed in reverse order of the stack.
    // 6. The time complexity of this algorithm is O(V + E), where V is the number of vertices and E is the number of edges in the graph.
    // 7. The space complexity is O(V) for the visited array and the stack.

    public static void main(String[] args) {
        int vertexCount = 8; // Number of vertices in the graph
        boolean[] visited = new boolean[vertexCount];
        // Initialize visited array to false
        for (int i = 0; i < vertexCount; i++) {
            visited[i] = false;
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            list.add(new ArrayList<>());
        }

        // Add edges to the graph (undirected graph example)
        DirectedGraph.addEdge(list, 0, 1);
        DirectedGraph.addEdge(list, 0, 4);
        DirectedGraph.addEdge(list, 1, 2);
        DirectedGraph.addEdge(list, 1, 3);
        DirectedGraph.addEdge(list, 1, 4);
        DirectedGraph.addEdge(list, 2, 3);
        DirectedGraph.addEdge(list, 3, 4);

        // Print the adjacency list
        DirectedGraph.printGraph(list);

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i < vertexCount; i++){
            if(!visited[i]){
                sortDFS(list, visited, stack, i);
            }
        }

        // Print the topological sort order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void sortDFS(ArrayList<ArrayList<Integer>> list, boolean[] visited, Stack<Integer> stack, int source) {
        List<Integer> neighbors = list.get(source);
    for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                sortDFS(list, visited, stack, neighbor);
            }
        }
        visited[source] = true;
        stack.push(source);
    }

}
