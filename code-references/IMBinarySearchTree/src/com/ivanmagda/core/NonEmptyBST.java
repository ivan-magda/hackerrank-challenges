package com.ivanmagda.core;

public class NonEmptyBST<T extends Comparable> implements Tree<T> {

    private T data;
    private Tree<T> left;
    private Tree<T> right;

    public NonEmptyBST(T element) {
        this.data = element;
        this.left = new EmptyBST<>();
        this.right = new EmptyBST<>();
    }

    public NonEmptyBST(T data, Tree<T> left, Tree<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int cardinality() {
        return 1 + left.cardinality() + right.cardinality();
    }

    @Override
    public boolean isMember(T element) {
        return data == element
                || (element.compareTo(data) < 0 ? left.isMember(element) : right.isMember(element));
    }

    @Override
    public NonEmptyBST<T> add(T element) {
        if (data == element) {
            return this;
        }

        return element.compareTo(data) < 0
                ? new NonEmptyBST<>(data, left.add(element), right)
                : new NonEmptyBST<>(data, left, right.add(element));
    }
}
