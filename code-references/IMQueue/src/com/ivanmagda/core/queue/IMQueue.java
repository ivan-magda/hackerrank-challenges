package com.ivanmagda.core.queue;

import com.ivanmagda.core.linkedlist.IMLinkedList;

public class IMQueue<T> {

    private IMLinkedList<T> linkedList;

    public IMQueue() {
        this.linkedList = new IMLinkedList<>();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public int getSize() {
        return linkedList.getSize();
    }

    public void enqueue(T value) {
        linkedList.addLast(value);
    }

    public T dequeue() {
        return linkedList.removeFirst();
    }

    public T peek() {
        return linkedList.getFirst();
    }

}
