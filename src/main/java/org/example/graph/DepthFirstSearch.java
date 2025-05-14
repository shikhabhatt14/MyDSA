package org.example.graph;

import java.util.ArrayList;

public class DepthFirstSearch {

    // This class implements the DFS algorithm for traversing a graph
    // using an adjacency list representation.
    // Applications of DFS include:
    // 1. Topological sorting of a directed acyclic graph (DAG).
    // 2. Finding strongly connected components in a directed graph.
    // 3. Solving puzzles and games (e.g., solving mazes).
    // 4. Finding cycles in a graph.
    // 5. Finding paths in a graph.
    // 6. Finding connected components in an undirected graph.
    // 7. Finding bridges and articulation points in a graph.
    // 8. Finding the longest path in a graph.
    // 9. Finding the shortest path in a graph (using backtracking).
    // 10. Finding the maximum flow in a flow network (using the Ford-Fulkerson algorithm).
    // 11. Finding the minimum spanning tree in a weighted graph (using Prim's algorithm).


    public static void main(String[] args) {
        int vertexCount = 8; // Number of vertices in the graph
        boolean[] visited = new boolean[vertexCount];
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
        UndirectedGraph.printGraph(list);

        // Perform DFS starting from vertex
        System.out.println("DFS starting from vertex 0:");
        //check for disconnected graph
        int count = 0;
        for(int i = 0; i < vertexCount; i++){
            if(!visited[i]){
                dfs(list, visited, i);
                count++;
            }
        }
        //count of connected components in a disconnected graph
        System.out.println("Number of connected components: " + count);
        //these connected components are also called as forests or island


    }

    public static void dfs(ArrayList<ArrayList<Integer>> list, boolean[] visited, int source){
        visited[source] = true;
        System.out.println(source + " ");
        for(int i = 0;i<list.get(source).size();i++){
            if(!visited[list.get(source).get(i)])
                dfs(list, visited, list.get(source).get(i));
        }
    }

}
