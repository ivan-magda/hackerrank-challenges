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

public class Node {

    private Node parent;
    private Node left;
    private Node right;
    private int data;

    Node(int data, Node parent) {
        this.parent = parent;
        this.data = data;
        this.left = null;
        this.right = null;
    }

    Node(int data) {
        this(data, null);
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
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
                left.parent = this;
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = node;
                right.parent = this;
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
