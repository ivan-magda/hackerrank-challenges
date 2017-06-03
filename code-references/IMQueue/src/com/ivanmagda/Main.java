package com.ivanmagda;

import com.ivanmagda.core.queue.IMQueue;

public class Main {

    public static void main(String[] args) {
        IMQueue<Integer> queue = new IMQueue<>();

        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(6);

        System.out.println("First out: " + queue.dequeue());
        System.out.println("Peek at second item: " + queue.peek());
        System.out.println("Second out: " + queue.dequeue());
        System.out.println("Third out: " + queue.dequeue());
    }
}
