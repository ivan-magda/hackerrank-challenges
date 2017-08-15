package com.ivanmagda.interfacelable;

public class NonEmptyBST<T extends Comparable<T>> implements Tree<T> {

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

    public static <T extends Comparable<T>> NonEmptyBST<T> buildFrom(T[] elements) {
        if (elements == null || elements.length == 0) {
            throw new IllegalArgumentException();
        }

        NonEmptyBST<T> tree = new NonEmptyBST<T>(elements[0]);
        for (int i = 1; i < elements.length; i++) {
            tree = tree.add(elements[i]);
        }

        return tree;
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
