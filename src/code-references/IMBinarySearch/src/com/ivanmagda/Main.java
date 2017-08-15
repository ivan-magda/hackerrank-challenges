package com.ivanmagda;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Search 7 recursively: " + IMBinarySearch.recursively(array, 7));
        System.out.println("Search 7 iterative: " + IMBinarySearch.iterative(array, 7));
    }
}
