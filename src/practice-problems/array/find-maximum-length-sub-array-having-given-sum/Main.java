import java.util.HashMap;
import java.util.Map;

/**
 * Find maximum length sub-array having given sum.
 * <p>
 * Given an array of integers, find maximum length sub-array having given sum.
 */
public class Main {

    private static void naiveFindMaxLengthSubArray(int[] array, int desiredSum) {
        int length = 0;
        int endIdx = -1;

        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if (sum == desiredSum && length < j - i + 1) {
                    length = j - i + 1;
                    endIdx = j;
                }
            }
        }

        System.out.println("[" + String.valueOf(endIdx - length + 1) + ", " + String.valueOf(endIdx) + "]");
    }

    /**
     * With use of map we could solve this problem in linear time.
     * The idea is to create an empty map to store ending index of first sub-array having given sum.
     * Then traverse the given array, and maintain sum of elements seen so far.
     */
    private static void mapFindMaxLengthSubArray(int[] array, int desiredSum) {
        Map<Integer, Integer> map = new HashMap<>(array.length);
        map.put(0, -1);

        int sum = 0;
        int length = 0;
        int endIdx = -1;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            // Update length and end index of maximum length sub-array having desired sum.
            if (map.containsKey(sum - desiredSum) && length < i - map.get(sum - desiredSum)) {
                length = i - map.get(sum - desiredSum);
                endIdx = i;
            }
        }

        System.out.println("[" + String.valueOf(endIdx - length + 1) + ", " + String.valueOf(endIdx) + "]");
    }

    public static void main(String[] args) {
        int[] array = {5, 6, -5, 5, 3, 5, 3, -2, 0};

        naiveFindMaxLengthSubArray(array, 8);
        mapFindMaxLengthSubArray(array, 8);
    }
}
