package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortingKahnsBFSBased {

    // This class implements Kahn's algorithm for topological sorting of a directed acyclic graph (DAG).
    // Topological sorting is a linear ordering of vertices such that for every directed edge u -> v,
    // vertex u comes before vertex v in the ordering.
    // Applications of topological sorting include:
    // 1. Task scheduling: Topological sorting can be used to determine the order in which tasks should be executed
    //    based on their dependencies.
    // 2. Build systems: Topological sorting can be used to determine the order in which files should be compiled
    //    based on their dependencies.
    // 3. Course scheduling: Topological sorting can be used to determine the order in which courses should be taken
    //    based on their prerequisites.
    // 4. Dependency resolution: Topological sorting can be used to determine the order in which dependencies should
    //    be resolved in a software project.
    // 5. Version control: Topological sorting can be used to determine the order in which changes should be applied
    //    in a version control system based on their dependencies.
    // 6. Data processing: Topological sorting can be used to determine the order in which data should be processed
    //    based on their dependencies.
    // 7. Circuit design: Topological sorting can be used to determine the order in which components should be connected
    //    in a circuit based on their dependencies.
    // 8. Project management: Topological sorting can be used to determine the order in which tasks should be completed
    //    in a project based on their dependencies.
    // 9. Workflow management: Topological sorting can be used to determine the order in which tasks should be executed
    //    in a workflow based on their dependencies.
    // 10. Data flow analysis: Topological sorting can be used to determine the order in which data should be processed
    //     in a data flow analysis based on their dependencies.

    public static void main(String[] args) {
        int vertexCount = 8; // Number of vertices in the graph
        int[] inDegree = new int[vertexCount];
        // Initialize visited array to false
        Arrays.fill(inDegree, 0);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            list.add(new ArrayList<>());
        }

        // Add edges to the graph (undirected graph example)
        addEdge(list, 0, 1, inDegree);
        addEdge(list, 0, 4, inDegree);
        addEdge(list, 1, 2, inDegree);
        //addEdge(list, 1, 3);
        //addEdge(list, 1, 4);
        addEdge(list, 2, 3, inDegree);
        addEdge(list, 3, 0, inDegree); // leading to cycle creation

        addEdge(list, 5, 6, inDegree);
        addEdge(list, 5, 7, inDegree);

        // Print the adjacency list
        DirectedGraph.printGraph(list);
        System.out.println();
        if(detectCycle(list, inDegree))
            System.out.println("Cycle detected in the graph.");
        else {
            System.out.println("No cycle detected in the graph.");
            sort(list, inDegree);
        }

    }

    public static void sort(ArrayList<ArrayList<Integer>> list, int[] indegree) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");
            ArrayList<Integer> neighbors = list.get(curr);
            for (int neighbor : neighbors) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    queue.add(neighbor);
            }
        }
    }

    public static boolean detectCycle(ArrayList<ArrayList<Integer>> list, int[] indegree) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            System.out.print(curr + " ");
            ArrayList<Integer> neighbors = list.get(curr);
            for (int neighbor : neighbors) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    queue.add(neighbor);
            }
        }

        //return Arrays.stream(indegree).anyMatch(i -> i > 0);

        if(count == list.size())
            return false; // No cycle detected
        else
            return true; // Cycle detected
    }


    //add Edge
    public static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int u, int v, int[] inDegree) {
        adjacencyList.get(u).add(v);
        inDegree[v]++; // Increment the in-degree of vertex v
        // No need to add the reverse edge for directed graph
    }

}
