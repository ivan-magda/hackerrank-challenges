package com.ivanmagda;

public class Main {

    public static void main(String[] args) {
        IMMinHeap heap = IMMinHeap.buildFrom(new int[]{12, 4, 5, 3, 8, 7});

        System.out.println("Min value: " + heap.peek());
        System.out.println("Median value: " + heap.getMedian());
    }
}
