package com.ivanmagda.naive;

public class Node {

    private Node left;
    private Node right;
    private int data;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getData() {
        return data;
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

    @Override
    public String toString() {
        if (left == null && right == null) {
            return "(" + String.valueOf(data) + ")";
        } else {
            return "(" +
                    (left == null ? "()" : left.toString()) + " " +
                    String.valueOf(data) + " " +
                    (right == null ? "()" : right.toString())
                    + ")";
        }
    }
}
