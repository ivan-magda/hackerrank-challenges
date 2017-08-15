package com.ivanmagda.sort;

public class SelectionSort {

    private SelectionSort() {
    }

    public static void sort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            int minIndex = findMinIndex(array, i, length);
            swap(array, i, minIndex);
        }
    }

    private static int findMinIndex(int[] array, int start, int end) {
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = start; i < end; i++) {
            int currentValue = array[i];
            if (currentValue < min) {
                min = currentValue;
                index = i;
            }
        }

        return index;
    }

    private static void swap(int[] array, int lhsIndex, int rhsIndex) {
        int temp = array[lhsIndex];
        array[lhsIndex] = array[rhsIndex];
        array[rhsIndex] = temp;
    }
}
