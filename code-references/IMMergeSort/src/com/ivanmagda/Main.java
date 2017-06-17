package com.ivanmagda;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {2, 1, 3, 1, 2};

        System.out.println("Inversions count: " + IMMergeSort.countInversions(array));

        IMMergeSort.sort(array);
        System.out.println("Sorted: " + Arrays.toString(array));
    }
}
