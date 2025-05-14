package org.example.graph;

public class GraphNode {
    private int vertex;
    private int weight;

    public GraphNode(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public int getVertex() {
        return vertex;
    }

    public int getWeight() {
        return weight;
    }
}
