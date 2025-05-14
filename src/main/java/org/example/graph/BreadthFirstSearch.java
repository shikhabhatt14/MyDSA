package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    // This class implements the BFS algorithm for traversing a graph
    // using an adjacency list representation.
    // Applications of BFS include:
    // 1. Finding the shortest path in an unweighted graph.
    // 2. Finding connected components in a graph.
    // 3. Solving puzzles and games (e.g., finding the shortest path in a maze).
    // 4. Web crawling and social network analysis.
    // 5. Broadcasting in networks.
    // 6. Finding the minimum spanning tree in a weighted graph (using Prim's algorithm).
    // 7. Finding the maximum flow in a flow network (using the Edmonds-Karp algorithm).
    // 8. Finding bipartite graphs.
    // 9. Finding the shortest path in a weighted graph (using Dijkstra's algorithm).
    // 10. Finding the shortest path in a grid or maze.
    // 11. Finding the shortest path in a tree.
    // 12. Finding the shortest path in a directed acyclic graph (DAG).
    // 13. Finding the shortest path in a directed graph.
    // 14. Finding the shortest path in a weighted directed graph.
    // 15. Finding the shortest path in a directed graph with negative weights (using Bellman-Ford algorithm).
    // 16. Finding the shortest path in a directed graph with cycles (using Johnson's algorithm).
    // 17. Finding the shortest path in a directed graph with negative cycles (using Bellman-Ford algorithm).
    // 18. Finding the shortest path in a directed graph with positive weights (using Dijkstra's algorithm).
    // 19. Finding the shortest path in a directed graph with positive and negative weights (using Bellman-Ford algorithm).

    static int vertexCount = 8; // Number of vertices in the graph

    public static void main(String[] args) {
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

        boolean[] visited = new boolean[vertexCount];
        Arrays.fill(visited, false);

        // Print the adjacency list
        UndirectedGraph.printGraph(list);

        // Perform BFS starting from vertex 0
        System.out.println("BFS starting from vertex 0:");
        bfs(list, 0, visited);

        //check for disconnected graph
        for(int i = 0; i < vertexCount; i++){
            if(!visited[i]){
                bfs(list, i, visited);
            }
        }
    }

    public static void bfs(ArrayList<ArrayList<Integer>> list, int start,boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            System.out.print(curr + " ");
            for(int i = 0; i < list.get(curr).size(); i++){
                int neighbor = list.get(curr).get(i);
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }



}
