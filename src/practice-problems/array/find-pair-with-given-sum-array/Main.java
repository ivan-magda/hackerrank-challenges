import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find a pair with given sum in it.
 */
public class Main {

    private static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    /**
     * Naive Solution O(n^2).
     * <p>
     * Naive solution would be to considered every pair in a given array
     * and return if desired sum is found.
     */
    private static Pair naiveFindPairWithSum(int[] array, int sum) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    return new Pair(array[i], array[j]);
                }
            }
        }

        return null;
    }

    /**
     * O(nlogn) solution using Sorting.
     * <p>
     * The idea is to sort the given array in ascending order and maintain search space by maintaining
     * two indexes (low and high) that initially points to two end-points of the array.
     * Then we loop till low is less than high index and reduce search space array[low...high] at each iteration of the loop.
     * We compare sum of elements present at index low and high with desired sum and increment low if sum is less
     * than the desired sum else we decrement high is sum is more than the desired sum.
     * Finally, we return if pair found in the array.
     */
    private static Pair sortFindPairWith(int[] array, int sum) {
        Arrays.sort(array);

        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            int currentSum = array[low] + array[high];
            if (currentSum == sum) {
                return new Pair(array[low], array[high]);
            }

            if (currentSum < sum) {
                low++;
            } else {
                high--;
            }
        }

        return null;
    }

    /**
     * O(n) solution using Hashing.
     * <p>
     * We can use map to easily solve this problem in linear time. The idea is to insert each element of the array[i]
     * in a map. We also checks if difference (array[i], sum - array[i]) already exists in the map or not.
     * If the difference is seen before, we print the pair and return.
     */
    private static Pair hashingFindPairWithSum(int[] array, int sum) {
        Map<Integer, Integer> map = new HashMap<>(array.length);

        for (int i = 0; i < array.length; i++) {
            int difference = sum - array[i];

            if (map.containsKey(difference)) {
                return new Pair(difference, array[i]);
            }

            map.put(array[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] array = {8, 2, 5, 9, 21, 2, 3};
        int naiveSum = 7;

        Pair naivePair = naiveFindPairWithSum(array.clone(), naiveSum);
        System.out.println(
                naivePair != null ?
                        "Found a pair with the given sum: " + String.valueOf(naiveSum)
                                + " : (" + naivePair.first + ", " + naivePair.second + ")."
                        : "No pair with given sum: " + String.valueOf(naiveSum) + " exists in the array."
        );

        int sortSum = 8;
        Pair sortPair = sortFindPairWith(array, sortSum);
        System.out.println(
                sortPair != null ?
                        "Found a pair with the given sum: " + String.valueOf(sortSum)
                                + " : (" + sortPair.first + ", " + sortPair.second + ")."
                        : "No pair with given sum: " + String.valueOf(sortSum) + " exists in the array."
        );

        int hashingSum = 5;
        Pair hashingPair = hashingFindPairWithSum(array, hashingSum);
        System.out.println(
                hashingPair != null ?
                        "Found a pair with the given sum: " + String.valueOf(hashingSum)
                                + " : (" + hashingPair.first + ", " + hashingPair.second + ")."
                        : "No pair with given sum: " + String.valueOf(hashingSum) + " exists in the array."
        );
    }
}
