package com.ivanmagda.core.list;

import com.ivanmagda.core.AbstractGraph;
import com.ivanmagda.core.Edge;
import com.ivanmagda.core.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class AdjacencyListGraph<T> extends AbstractGraph<T> {

    private static final int ADJACENCY_INITIAL_CAPACITY = 10;

    private List<EdgeList<T>> adjacencyList = new ArrayList<>(ADJACENCY_INITIAL_CAPACITY);

    public AdjacencyListGraph() {
        super();
    }

    public AdjacencyListGraph(AbstractGraph<T> graph) {
        super(graph);
    }

    public List<Vertex<T>> getVertices() {
        List<Vertex<T>> vertices = new ArrayList<>(adjacencyList.size());
        for (EdgeList<T> edgeList : adjacencyList) {
            vertices.add(edgeList.getVertex());
        }

        return vertices;
    }

    public List<Edge<T>> getEdges() {
        HashSet<Edge<T>> allEdges = new HashSet<>(adjacencyList.size() * 2);
        for (EdgeList<T> edgeList : adjacencyList) {
            if (edgeList.getEdges() != null) {
                allEdges.addAll(edgeList.getEdges());
            }
        }

        return new ArrayList<>(allEdges);
    }

    @Override
    public Vertex<T> createVertex(T data) {
        List<Vertex<T>> matchingVertices = getVertices().stream()
                .filter(vertex -> vertex.getData().equals(data))
                .collect(Collectors.toList());

        if (matchingVertices != null && matchingVertices.size() > 0) {
            return matchingVertices.get(matchingVertices.size() - 1);
        }

        Vertex<T> vertex = new Vertex<>(data, adjacencyList.size());
        adjacencyList.add(new EdgeList<>(vertex));

        return vertex;
    }

    @Override
    public void addDirectedEdge(Vertex<T> from, Vertex<T> to, double weight) {
        Edge<T> edge = new Edge<>(from, to, weight);
        EdgeList<T> edgeList = adjacencyList.get(from.getIndex());

        if (edgeList.getEdges() != null) {
            edgeList.addEdge(edge);
        } else {
            edgeList.setEdges(new ArrayList<>(Arrays.asList(edge)));
        }
    }

    @Override
    public void addUndirectedEdge(Vertex<T> from, Vertex<T> to, double weight) {
        addDirectedEdge(from, to, weight);
        addDirectedEdge(to, from, weight);
    }

    @Override
    public double getWeightFrom(Vertex<T> sourceVertex, Vertex<T> destinationVertex) {
        List<Edge<T>> edges = adjacencyList.get(sourceVertex.getIndex()).getEdges();

        if (edges == null) {
            return 0;
        }

        for (Edge<T> edge : edges) {
            if (edge.getTo().equals(destinationVertex)) {
                return edge.getWeight();
            }
        }

        return 0;
    }

    @Override
    public List<Edge<T>> getEdgesFrom(Vertex<T> sourceVertex) {
        List<Edge<T>> edges = adjacencyList.get(sourceVertex.getIndex()).getEdges();
        return edges != null ? edges : new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder rows = new StringBuilder(100);

        for (EdgeList<T> edgeList : adjacencyList) {
            List<Edge<T>> edges = edgeList.getEdges();
            if (edges == null) continue;

            StringBuilder row = new StringBuilder();
            for (Edge<T> edge : edges) {
                row.append("(")
                        .append(String.valueOf(edge.getTo().getData())).append(": ")
                        .append(String.valueOf(edge.getWeight()))
                        .append(")").append(", ");
            }

            String rowString = row.toString().trim();
            rowString = rowString.substring(0, rowString.lastIndexOf(','));

            rows.append(String.valueOf(edgeList.getVertex().getData())).append(" -> [")
                    .append(rowString).append("]").append("\n");
        }

        return rows.toString().trim();
    }
}
