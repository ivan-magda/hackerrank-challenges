package com.ivanmagda.core;

public class Vertex<T> {

    private T data;
    private int index;

    public Vertex(T data, int index) {
        this.data = data;
        this.index = index;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Vertex<?> vertex = (Vertex<?>) obj;

        return index == vertex.index && data.equals(vertex.data);
    }

    @Override
    public int hashCode() {
        int result = data.hashCode();
        result = 31 * result + index;
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(index) + ": " + data;
    }
}
