package com.ivanmagda;

/**
 * Tree interface.
 */
public interface Tree<T extends Comparable> {
    public boolean isEmpty();
    public int cardinality();
    public boolean isMember(T element);
    public NonEmptyBST<T> add(T element);
}
