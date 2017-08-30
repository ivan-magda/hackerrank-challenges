import java.util.Arrays;

/**
 * Rearrange the array with alternate high and low elements.
 * <p>
 * Given an array of integers, rearrange the array such that every second element of the array is greater
 * than its left and right elements. Assume no duplicate elements are present in the array.
 */
public class Main {

    /**
     * A simple solution would be to sort the array in ascending order first.
     * Then we take another auxiliary array and fill it with elements starting from the two end-points of the sorted
     * array in alternate order.
     */
    private static int[] rearranged(int[] array) {
        int[] sorted = array.clone();
        Arrays.sort(sorted);

        int start = 0, end = sorted.length - 1, copy = 0;
        int[] rearranged = new int[sorted.length];

        while (start < end) {
            rearranged[copy++] = sorted[start++];
            rearranged[copy++] = sorted[end--];
        }

        // Copy last elements for odd length.
        while (copy < array.length) {
            rearranged[copy++] = array[start++];
        }

        return rearranged;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Rearranged: " + Arrays.toString(rearranged(array)));
    }
}
