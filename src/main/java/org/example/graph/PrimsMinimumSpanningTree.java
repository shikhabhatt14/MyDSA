package org.example.graph;

import java.util.Arrays;

public class PrimsMinimumSpanningTree {

    // Prim's algorithm to find the minimum spanning tree of a graph
    // This algorithm is used to find the minimum spanning tree of a connected, undirected graph.
    // It is a greedy algorithm that builds the minimum spanning tree by adding edges one by one.
    // Applications of Prim's algorithm include:
    // 1. Network design: Prim's algorithm can be used to design a network with minimum cost.
    // 2. Minimum spanning tree: Prim's algorithm can be used to find the minimum spanning tree of a graph.
    // 3. Clustering: Prim's algorithm can be used to cluster data points based on their distances.
    // 4. Image segmentation: Prim's algorithm can be used to segment an image into regions based on their colors.
    // 5. Geographic information systems (GIS): Prim's algorithm can be used to find the minimum spanning tree of a geographic network.
    // 6. Circuit design: Prim's algorithm can be used to design a circuit with minimum cost.
    // 7. Transportation networks: Prim's algorithm can be used to design a transportation network with minimum cost.
    // 8. Telecommunication networks: Prim's algorithm can be used to design a telecommunication network with minimum cost.
    // 9. Power grid design: Prim's algorithm can be used to design a power grid with minimum cost.
    // 10. Robotics: Prim's algorithm can be used to plan the path of a robot in a grid or a graph.

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        primsAlgorithm(graph);
    }

    public static void primsAlgorithm(int[][] graph){
        int vCount = graph.length;

        // Array to store the minimum cost of each vertex
        int[] key = new int[vCount];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0; // Starting vertex
        int result = 0;

        boolean[] mstSet = new boolean[vCount];

        for(int i=0; i < vCount; i++){
            for(int v=i;v<vCount;v++){
                if(!mstSet[i] && graph[i][v] != 0 && graph[i][v] < key[v])
                    key[v] = graph[i][v];
            }
            mstSet[i] = true;

        }

        for(int i=0; i < vCount; i++){
            System.out.println(mstSet[i]+" "+key[i]);
        }

        System.out.println("Minimum spanning tree is: ");
        for(int i=0; i < vCount; i++){
            System.out.print(i);
            for(int j=i+1; j < vCount; j++){
                if(graph[i][j] == key[j])
                    System.out.print(" -> " + j);
            }
            System.out.println();
        }

        for(int i=0; i < vCount; i++){
            if(mstSet[i])
                result += key[i];
        }
        System.out.println("Minimum cost of the spanning tree is: " + result);

    }

}
