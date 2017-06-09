package com.ivanmagda.core;

import java.util.List;

public class EdgeList<T> {

    private Vertex<T> vertex;
    private List<Edge<T>> edges;

    public EdgeList(Vertex<T> vertex) {
        this.vertex = vertex;
    }

    public Vertex<T> getVertex() {
        return vertex;
    }

    public void setVertex(Vertex<T> vertex) {
        this.vertex = vertex;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge<T>> edges) {
        this.edges = edges;
    }

    public void addEdge(Edge<T> edge) {
        if (edges != null) {
            edges.add(edge);
        }
    }
}
