package com.ivanmagda.core;

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

    public Node<T> getHead() {
        return head;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        if (head == null) {
            assert count == 0;
            return true;
        }

        return false;
    }

    public void add(T newData) {
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

    public void removeLast() {
        if (head == null) {
            throw new NullPointerException("Head is null");
        }

        Node<T> current = head;

        if (current.getNext() == null) {
            head = null;
            count = 0;
        } else {
            while (current.getNext().getNext() != null) current = current.getNext();
            current.setNext(null);
            count--;
        }
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
