package com.ivanmagda.interfacelable;

/**
 * Tree interface.
 */
public interface Tree<T extends Comparable<T>> {
    public boolean isEmpty();

    public int cardinality();

    public boolean isMember(T element);

    NonEmptyBST<T> add(T element);
}
