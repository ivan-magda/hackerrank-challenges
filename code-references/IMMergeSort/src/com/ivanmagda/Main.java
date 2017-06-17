package com.ivanmagda;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{9, 4, 5, 2, 86, 3, 7};
        IMMergeSort.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
