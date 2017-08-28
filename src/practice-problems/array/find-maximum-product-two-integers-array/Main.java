import java.util.Arrays;

/**
 * Find maximum product of two integers in an array.
 * <p>
 * Given an array of integers, find maximum product of two integers in an array.
 */
public class Main {

    // Naive solution to find maximum product of two integers
    // in an array
    private static void naiveFindMaxProduct(int[] array) {
        int maxProduct = Integer.MIN_VALUE;
        int lhsIdx = -1, rhsIdx = -1;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int current = array[i] * array[j];
                if (current > maxProduct) {
                    maxProduct = current;
                    lhsIdx = i;
                    rhsIdx = j;
                }
            }
        }

        if (lhsIdx != -1) {
            System.out.println("Pair is (" + array[lhsIdx] + ", " + array[rhsIdx] + ")");
        } else {
            System.out.println("No pair found");
        }
    }

    private static void sortFindMaximumProduct(int arr[]) {
        int length = arr.length;

        Arrays.sort(arr);

        // maximum product is formed by maximum of
        // 1. product of first two elements or
        // 2. product of last two elements

        if ((arr[0] * arr[1]) > (arr[length - 1] * arr[length - 2])) {
            System.out.print("Pair is (" + arr[0] + ", " + arr[1] + ")");
        } else {
            System.out.print("Pair is (" + arr[length - 1] + ", " + arr[length - 2] + ")");
        }
    }

    /**
     * Also, we can solve this problem in linear time as we need only maximum, second maximum,
     * minimum and second minimum element to solve this problem.
     * We can compute all these in only single traversal of the array which accounts for O(n) time complexity.
     */

    public static void main(String[] args) {
        int[] array = {-10, -3, 5, 6, -2};

        naiveFindMaxProduct(array);
        sortFindMaximumProduct(array.clone());
    }
}
