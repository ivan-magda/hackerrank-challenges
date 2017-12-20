/*
  Copyright (c) 2017 Ivan Magda

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
 */

package com.ivanmagda.naive;

import java.util.Stack;

public class BinarySearchTree {

    public interface TreeWalkCallback {
        void process(int value);
    }

    private Node head;

    public BinarySearchTree(int value) {
        this.head = new Node(value);
    }

    public BinarySearchTree(int[] values) {
        if (values.length < 1) {
            throw new Error("Pass non-empty array");
        } else {
            this.head = new Node(values[0]);

            for (int i = 1; i < values.length; i++) {
                add(values[i]);
            }
        }
    }

    public void add(int value) {
        head.insert(value);
    }

    public Node search(int value) {
        return head.search(value);
    }

    public Node iterativeSearch(int value) {
        Node node = head;

        while (node != null && value != node.getData()) {
            node = value < node.getData() ? node.getLeft() : node.getRight();
        }

        return node;
    }

    public boolean contains(int value) {
        return head.contains(value);
    }

    public Node getMinimum() {
        return head.getMinimum();
    }

    public Node minimum(Node node) {
        return node != null ? node.getMinimum() : null;
    }

    public Node getMaximum() {
        return head.getMaximum();
    }

    public Node maximum(Node node) {
        return node != null ? node.getMaximum() : null;
    }

    public Node getSuccessor(Node node) {
        if (node == null) {
            return null;
        } else if (node.getRight() != null) {
            return node.getRight().getMinimum();
        }

        Node current = node;
        Node parent = node.getParent();
        while (parent != null && current == parent.getRight()) {
            current = parent;
            parent = parent.getParent();
        }

        return parent;
    }

    public Node getPredecessor(Node node) {
        if (node == null) {
            return null;
        } else if (node.getLeft() != null) {
            return node.getLeft().getMaximum();
        }

        Node current = node;
        Node parent = node.getParent();
        while (parent != null && current == parent.getLeft()) {
            current = parent;
            parent = parent.getParent();
        }

        return parent;
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

    public void inorderTreeWalkWithoutRecursion(TreeWalkCallback treeWalkCallback) {
        if (head == null) {
            return;
        }

        // Keep the nodes in the path that are waiting to be visited.
        Stack<Node> stack = new Stack<>();
        Node node = head;

        // First node to be visited will be the left one.
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
        }

        // Traverse the tree.
        while (!stack.isEmpty()) {
            node = stack.pop();
            treeWalkCallback.process(node.getData());

            if (node.getRight() != null) {
                node = node.getRight();

                while (node != null) {
                    stack.push(node);
                    node = node.getLeft();
                }
            }
        }
    }

    public void inorderTreeWalk(TreeWalkCallback treeWalkCallback) {
        inorderTraversal(head, treeWalkCallback);
    }

    private void inorderTraversal(Node node, TreeWalkCallback treeWalkCallback) {
        if (node != null) {
            inorderTraversal(node.getLeft(), treeWalkCallback);
            treeWalkCallback.process(node.getData());
            inorderTraversal(node.getRight(), treeWalkCallback);
        }
    }

    public void preorderTreeWalk(TreeWalkCallback treeWalkCallback) {
        preorderTraversal(head, treeWalkCallback);
    }

    private void preorderTraversal(Node node, TreeWalkCallback treeWalkCallback) {
        if (node != null) {
            treeWalkCallback.process(node.getData());
            preorderTraversal(node.getLeft(), treeWalkCallback);
            preorderTraversal(node.getRight(), treeWalkCallback);
        }
    }

    public void postorderTreeWalk(TreeWalkCallback treeWalkCallback) {
        postorderTraversal(head, treeWalkCallback);
    }

    private void postorderTraversal(Node node, TreeWalkCallback treeWalkCallback) {
        if (node != null) {
            postorderTraversal(node.getLeft(), treeWalkCallback);
            postorderTraversal(node.getRight(), treeWalkCallback);
            treeWalkCallback.process(node.getData());
        }
    }

    @Override
    public String toString() {
        return head.toString();
    }
}
