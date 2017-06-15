package com.ivanmagda;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        IMMinHeap minHeap = new IMMinHeap();

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            minHeap.add(random.nextInt(20) + 1);
        }

        System.out.println("Min value: " + minHeap.peek());
        minHeap.poll();

        System.out.println("New min value: " + minHeap.peek());
    }
}
