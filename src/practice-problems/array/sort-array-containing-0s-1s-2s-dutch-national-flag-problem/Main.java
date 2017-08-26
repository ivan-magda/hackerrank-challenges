import java.util.Arrays;

/**
 * Sort an array containing 0’s, 1’s and 2’s (Dutch national flag problem).
 * Given an array containing only 0’s, 1’s and 2’s, sort the array in linear time and using constant space.
 */
public class Main {

    /**
     * Linear-time partition routine to sort an array containing 0, 1 and 2.
     * It similar to three-way Partitioning for Dutch national flag problem.
     */
    private static void threeWayPartition(int[] array) {
        final int PIVOT = 1;

        int start = 0, mid = 0;
        int end = array.length - 1;

        while (mid <= end) {
            if (array[mid] < PIVOT) {
                swap(array, start++, mid++);
            } else if (array[mid] > PIVOT) {
                swap(array, mid, end--);
            } else {
                mid++;
            }
        }
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 0, 0, 1, 1, 0, 0, 2};
        System.out.println("Unsorted :" + Arrays.toString(array));

        threeWayPartition(array);
        System.out.println("Sorted: " + Arrays.toString(array));
    }
}
