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

/*
package com.ivanmagda;

import java.util.LinkedList;

class Main<T> {

    private LinkedList<T> queue;

    public Main() {
        queue = new LinkedList<T>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public void enqueue(T value) {
        queue.addLast(value);
    }

    public T dequeue() {
        return queue.remove();
    }

    public T peek() {
        return queue.getFirst();
    }

    public static void main(String args[]) {
        Main<Integer> integerQueue = new Main<>();

        integerQueue.enqueue(5);
        integerQueue.enqueue(7);
        integerQueue.enqueue(6);

        System.out.println("First out: " + integerQueue.dequeue());
        System.out.println("Peek at second item: " + integerQueue.peek());
        System.out.println("Second out: " + integerQueue.dequeue());
        System.out.println("Third out: " + integerQueue.dequeue());
    }
}

 */