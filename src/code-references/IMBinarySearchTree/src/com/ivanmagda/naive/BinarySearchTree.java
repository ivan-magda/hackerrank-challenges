package com.ivanmagda.naive;

public class BinarySearchTree {

    private Node head;

    public BinarySearchTree(int value) {
        this.head = new Node(value);
    }

    public void add(int value) {
        head.insert(value);
    }

    public Node search(int value) {
        return head.search(value);
    }

    public boolean contains(int value) {
        return head.contains(value);
    }

    public Node getMinimum() {
        return head.getMinimum();
    }

    public Node getMaximum() {
        return head.getMaximum();
    }

    public boolean remove(int value) {
        if (head == null) {
            return false;
        } else {
            if (head.getData() == value) {
                Node auxRoot = new Node(0);
                auxRoot.setLeft(head);

                boolean result = head.remove(value, auxRoot);
                head = auxRoot.getLeft();

                return result;
            } else {
                return head.remove(value, null);
            }
        }
    }

    @Override
    public String toString() {
        return head.toString();
    }
}
