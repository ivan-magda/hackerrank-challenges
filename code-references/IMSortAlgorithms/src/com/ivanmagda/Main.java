package com.ivanmagda;

import com.ivanmagda.utils.SortUtils;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {5, 2, 4, 6, 1, 3};
        System.out.println("Insertion sort: " + Arrays.toString(SortUtils.insertionSort(array)));
    }
}
