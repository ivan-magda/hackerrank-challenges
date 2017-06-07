package com.ivanmagda.core;

/**
 * Tree interface.
 */
public interface Tree<T extends Comparable<T>> {
    public boolean isEmpty();

    public int cardinality();

    public boolean isMember(T element);

    public NonEmptyBST<T> add(T element);
}
