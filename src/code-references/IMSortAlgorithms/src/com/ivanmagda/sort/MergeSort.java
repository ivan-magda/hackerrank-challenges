package com.ivanmagda.sort;

public class MergeSort {

    private MergeSort() {
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int start, int end) {
        if (start < end) {
            int middle = start + (end - start) / 2;

            sort(array, start, middle);
            sort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    private static void merge(int[] array, int start, int middle, int end) {
        int countLeft = middle - start + 1;
        int countRight = end - middle;

        int[] leftArr = new int[countLeft];
        int[] rightArr = new int[countRight];

        System.arraycopy(array, start, leftArr, 0, countLeft);
        System.arraycopy(array, middle + 1, rightArr, 0, countRight);

        int lhsIdx = 0, rhsIdx = 0, copyIndex = start;
        while (lhsIdx < countLeft && rhsIdx < countRight) {
            if (leftArr[lhsIdx] <= rightArr[rhsIdx]) {
                array[copyIndex++] = leftArr[lhsIdx++];
            } else {
                array[copyIndex++] = rightArr[rhsIdx++];
            }
        }

        System.arraycopy(leftArr, lhsIdx, array, copyIndex, countLeft - lhsIdx);
        System.arraycopy(rightArr, rhsIdx, array, copyIndex, countRight - rhsIdx);
    }
}
