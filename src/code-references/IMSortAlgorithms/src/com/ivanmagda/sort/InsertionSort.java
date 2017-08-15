package com.ivanmagda.sort;

public class InsertionSort {

    private InsertionSort() {
    }

    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentValue = array[i];
            int previousIndex = i - 1;

            while (previousIndex >= 0 && array[previousIndex] > currentValue) {
                array[previousIndex + 1] = array[previousIndex];
                previousIndex--;
            }

            array[previousIndex + 1] = currentValue;
        }
    }
}
