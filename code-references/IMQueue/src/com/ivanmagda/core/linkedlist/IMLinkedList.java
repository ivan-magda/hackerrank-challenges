package com.ivanmagda.core.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IMLinkedList<T> implements Iterable<Node<T>>, Iterator<Node<T>> {

    private Node<T> head;
    private int count;

    private int iteratorIndex = 0;

    public IMLinkedList() {
        this.head = null;
        this.count = 0;
    }

    public IMLinkedList(Node<T> head) {
        this.head = head;
        this.count = 1;
    }

    public int getSize() {
        return count;
    }

    public boolean isEmpty() {
        if (head == null) {
            assert count == 0;
            return true;
        }

        return false;
    }

    public void addLast(T newData) {
        Node<T> newNode = new Node<T>(newData);
        Node<T> current = head;

        if (current == null) {
            head = newNode;
            count = 1;
        } else {
            while (current.getNext() != null) current = current.getNext();
            current.setNext(newNode);
            count++;
        }
    }

    public T removeFirst() {
        if (head == null) {
            throw new NullPointerException("Head is null");
        }

        T value = head.getData();
        head = head.getNext();
        count--;

        return value;
    }

    public T removeLast() {
        if (head == null) {
            throw new NullPointerException("Head is null");
        }

        Node<T> current = head;
        T value;

        if (current.getNext() == null) {
            value = head.getData();
            head = null;
            count = 0;
        } else {
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }

            value = current.getNext().getData();
            current.setNext(null);
            count--;
        }

        return value;
    }

    private Node<T> getNodeAt(int index) throws IndexOutOfBoundsException {
        RuntimeException indexOutOfBoundsException = new IndexOutOfBoundsException("Receive an illegal index, that out of bounds.");
        if (index < 0 || index >= count) {
            throw indexOutOfBoundsException;
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++, current = current.getNext()) {
            if (current == null) throw indexOutOfBoundsException;
        }

        return current;
    }

    public T getAt(int index) throws IndexOutOfBoundsException {
        return getNodeAt(index).getData();
    }

    public T getFirst() {
        if (head == null) {
            throw new NullPointerException();
        }

        return head.getData();
    }

    @Override
    public boolean hasNext() {
        if (iteratorIndex < count) {
            return true;
        } else {
            iteratorIndex = 0;
            return false;
        }
    }

    @Override
    public Node<T> next() {
        if (iteratorIndex == count) {
            throw new NoSuchElementException();
        }

        return getNodeAt(iteratorIndex++);
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return this;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "IMLinkedList{" +
                "head=" + head +
                ", count=" + count +
                '}';
    }
}
