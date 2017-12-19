package com.ivanmagda.naive;

public class BinarySearchTree {

    private Node head;

    public BinarySearchTree(int value) {
        this.head = new Node(value);
    }

    public void add(int value) {
        head.insert(value);
    }

    public boolean contains(int value) {
        return head.contains(value);
    }

    @Override
    public String toString() {
        return head.toString();
    }
}
