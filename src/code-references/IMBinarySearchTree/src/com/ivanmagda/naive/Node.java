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

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
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

    public Node search(int value) {
        if (data == value) {
            return this;
        } else if (value <= data) {
            return left != null ? left.search(value) : null;
        } else {
            return right != null ? right.search(value) : null;
        }
    }

    public boolean contains(int value) {
        return search(value) != null;
    }

    public Node getMinimum() {
        Node node = this;

        while (node.getLeft() != null) {
            node = node.getLeft();
        }

        return node;
    }

    public Node getMaximum() {
        Node node = this;

        while (node.getRight() != null) {
            node = node.getRight();
        }

        return node;
    }

    public boolean remove(int value, Node parent) {
        if (value < data) {
            return left != null && left.remove(value, this);
        } else if (value > data) {
            return right != null && right.remove(value, this);
        } else {
            if (left != null && right != null) {
                data = right.getMinimum().data;
                right.remove(data, this);
            } else if (parent.left == this) {
                parent.left = (left != null) ? left : right;
            } else if (parent.right == this) {
                parent.right = (left != null) ? left : right;
            }

            return true;
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
