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

    public void iterativeInsert(int value) {
        Node toInsert = new Node(value);
        Node parent = null;
        Node current = head;

        while (current != null) {
            parent = current;
            current = toInsert.getData() < current.getData()
                    ? current.getLeft()
                    : current.getRight();
        }

        toInsert.setParent(parent);

        if (parent == null) {
            head = toInsert;
        } else if (toInsert.getData() < parent.getData()) {
            parent.setLeft(toInsert);
        } else {
            parent.setRight(toInsert);
        }
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

    public int getHeight() {
        return getHeight(head);
    }

    private int getHeight(Node node) {
        if (node == null || node.isLeaf()) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
        }
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

    /**
     * Используется для перемещения поддеревьев в бинарном дереве поиска.
     * Заменяет одно поддерево, являющееся дочерним по отношению к своему родителю, другим поддеревом.
     */
    private void transplant(Node parent, Node child) {
        if (parent.getParent() == null) {
            head = child;
        } else if (parent == parent.getParent().getLeft()) {
            parent.getParent().setLeft(child);
        } else {
            parent.getParent().setRight(child);
        }

        if (child != null) {
            child.setParent(parent.getParent());
        }
    }

    public void delete(Node node) {
        // Процедура удаления содержит 4 случая:
        //
        // 1) Когда удаляемая вершина не содержит левого дочернего узла, то мы просто заменяем удаляемую вершину его
        // правым дочерним узлом, который может быть (или не быть) null.
        if (node.getLeft() == null) {
            transplant(node, node.getRight());

            // 2) Есди удаляемая вершина имеет только один дочерний узел, являющейся его левым дочерним узлом,
            // то мы заменяем удаляемую вершину на его левую дочернюю вершину.
        } else if (node.getRight() == null) {
            transplant(node, node.getLeft());
        } else {
            // В противном случае удаляемая вершина имеет левый и правый дочерние узлы. Мы находим узел y (минимальный),
            // следующий за удаляемым. Этот узел располагается в правом поддереве.
            Node min = minimum(node.getRight());

            // 4) В противном случае y находится в правом поддереве узла z, но не является правым дочерним узлом z.
            // В этом случае мы сначала заменяем y его собственным правым дочерним узлом, а затем заменяем z на y.
            if (min.getParent() != node) {
                transplant(min, min.getRight());
                min.setRight(node.getRight());
                min.getRight().setParent(min);
            }

            // 3) Если y является правым дочерним узлом z, то мы заменяем z на y, оставляя нетронутым правый дочерний
            // по отношению к y узел.
            transplant(node, min);
            min.setLeft(node.getLeft());
            min.getLeft().setParent(min);
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
