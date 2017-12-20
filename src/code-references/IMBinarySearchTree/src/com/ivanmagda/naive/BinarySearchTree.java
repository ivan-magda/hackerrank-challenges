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

public class BinarySearchTree {

    public interface TreeWalkCallback {
        void process(int value);
    }

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

    public void inorderTreeWalk(TreeWalkCallback callback) {
        _inorderTreeWalk(head, callback);
    }

    private void _inorderTreeWalk(Node node, TreeWalkCallback callback) {
        if (node != null) {
            _inorderTreeWalk(node.getLeft(), callback);
            callback.process(node.getData());
            _inorderTreeWalk(node.getRight(), callback);
        }
    }

    @Override
    public String toString() {
        return head.toString();
    }
}
