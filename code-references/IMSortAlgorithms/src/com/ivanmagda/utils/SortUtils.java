package com.ivanmagda.utils;

import com.ivanmagda.sort.InsertionSort;
import com.ivanmagda.sort.SelectionSort;

public class SortUtils {

    private SortUtils() {
    }

    public static int[] insertionSort(int[] array) {
        int[] arrayToSort = array.clone();
        InsertionSort.sort(arrayToSort);
        return arrayToSort;
    }

    public static int[] selectionSort(int[] array) {
        int[] arrayToSort = array.clone();
        SelectionSort.sort(arrayToSort);
        return arrayToSort;
    }
}
