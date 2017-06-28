package com.ivanmagda.utils;

import com.ivanmagda.sort.InsertionSort;

public class SortUtils {

    private SortUtils() {
    }

    public static int[] insertionSort(int[] array) {
        int[] arrayToSort = array.clone();
        InsertionSort.sort(arrayToSort);
        return arrayToSort;
    }
}
