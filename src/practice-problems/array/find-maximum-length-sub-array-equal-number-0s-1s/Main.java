import java.util.HashMap;
import java.util.Map;

/**
 * Find maximum length sub-array having equal number of 0’s and 1’s.
 * <p>
 * Given an binary array containing 0 and 1, find maximum length sub-array having equal number of 0’s and 1’s.
 */
public class Main {

    /**
     * We can use map to solve this problem in linear time.
     * <p>
     * The idea is to replace 0 with -1 and find out the largest subarray with 0 sum.
     * To find largest subarray with 0 sum, we create an empty map which stores the ending index of first sub-array
     * having given sum. We traverse the given array, and maintain sum of elements seen so far.
     */
    private static void findMaxLenBinarySubArray(int[] array) {
        Map<Integer, Integer> map = new HashMap<>(array.length);
        map.put(0, -1);

        int sum = 0;
        int endIdx = -1;
        int length = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i] == 0 ? -1 : 1;

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else if (length < i - map.get(sum)) {
                length = i - map.get(sum);
                endIdx = i;
            }
        }

        if (endIdx == -1) {
            System.out.println("No sub-array exists.");
        } else {
            System.out.println("[" + String.valueOf(endIdx - length + 1) + ", " + String.valueOf(endIdx) + "]");
        }
    }

    public static void main(String[] args) {
        int[] binaryArray = {0, 0, 1, 0, 1, 0, 0};
        findMaxLenBinarySubArray(binaryArray);
    }
}
