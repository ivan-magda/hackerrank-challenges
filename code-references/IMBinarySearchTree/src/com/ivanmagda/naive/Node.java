package com.ivanmagda.naive;

public class Node {

    private Node left;
    private Node right;
    private int data;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void insert(int value) {
        Node node = new Node(value);

        if (value <= data) {
            if (left == null) {
                left = node;
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = node;
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value) {
        if (data == value) {
            return true;
        } else if (value <= data) {
            return left != null && left.contains(value);
        } else {
            return right != null && right.contains(value);
        }
    }
}
