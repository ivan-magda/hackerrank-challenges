package com.ivanmagda;

public class IMMergeSort {

    private IMMergeSort() {
    }

    public static void sort(int[] array) {
        if (array == null || array.length <= 1) return;
        sort(array, new int[array.length], 0, array.length - 1);
    }

    public static long countInversions(int[] array) {
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);

        return sort(copy, new int[array.length], 0, array.length - 1);
    }

    private static long sort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return 0;
        }

        int middle = (leftStart + rightEnd) / 2;
        long left = sort(array, temp, leftStart, middle);
        long right = sort(array, temp, middle + 1, rightEnd);

        return left + right + mergeHalves(array, temp, leftStart, rightEnd);
    }

    private static long mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
        int middle = (rightEnd + leftStart) / 2;
        int rightStart = middle + 1;
        int size = rightEnd - leftStart + 1;
        long count = 0;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= middle && right <= rightEnd) {
            if (array[left] <= array[right]) {
                temp[index++] = array[left++];
            } else {
                temp[index++] = array[right++];
                count += middle - left + 1;
            }
        }

        System.arraycopy(array, left, temp, index, middle - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);

        return count;
    }
}
