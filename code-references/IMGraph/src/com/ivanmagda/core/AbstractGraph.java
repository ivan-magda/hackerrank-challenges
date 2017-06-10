package com.ivanmagda.core;

import java.util.List;

public abstract class AbstractGraph<T> {

    protected List<Vertex<T>> vertices;
    protected List<Edge<T>> edges;

    public AbstractGraph() {
    }

    public AbstractGraph(AbstractGraph<T> graph) {
        for (Edge<T> edge : graph.edges) {
            Vertex<T> from = createVertex(edge.getFrom().getData());
            Vertex<T> to = createVertex(edge.getTo().getData());

            addDirectedEdge(from, to, edge.getWeight());
        }
    }

    public abstract Vertex<T> createVertex(T data);

    public abstract void addDirectedEdge(Vertex<T> from, Vertex<T> to, double weight);

    public abstract void addUndirectedEdge(Vertex<T> from, Vertex<T> to, double weight);

    public abstract double getWeightFrom(Vertex<T> sourceVertex, Vertex<T> destinationVertex);

    public abstract List<Edge<T>> getEdgesFrom(Vertex<T> sourceVertex);
}
