package com.ivanmagda.core;

public class Edge<T> {

    private Vertex<T> from;
    private Vertex<T> to;

    private double weight;

    public Edge(Vertex<T> from, Vertex<T> to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Vertex<T> getFrom() {
        return from;
    }

    public void setFrom(Vertex<T> from) {
        this.from = from;
    }

    public Vertex<T> getTo() {
        return to;
    }

    public void setTo(Vertex<T> to) {
        this.to = to;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge<?> edge = (Edge<?>) o;

        return Double.compare(edge.weight, weight) == 0
                && from.equals(edge.from)
                && to.equals(edge.to);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = from.hashCode();
        result = 31 * result + to.hashCode();
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return from + " -" + weight + "-> " + to;
    }
}
