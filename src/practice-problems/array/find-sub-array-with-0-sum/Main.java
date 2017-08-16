/**
 * Given an array of integers, print all subarrays having 0 sum.
 */
public class Main {

    /**
     * Naive solution.
     * <p>
     * Naive solution would be to consider all sub-arrays and find its sum.
     * If sub-array sum is equal to 0, we print it.
     * The time complexity of naive solution is O(n^3) as there are n^2 sub-arrays and it takes O(n)
     * time to find sum of its elements. The method can be optimized to run in O(n^2) time by calculating
     * sub-array sum in constant time.
     */
    private static void printAllSubArraysWithZeroSum(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];

                if (sum == 0) {
                    System.out.println("Sub-array [" + i + "..." + j + "]");
                }
            }
        }
    }

    public static void main(String[] args) {
        int array[] = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        printAllSubArraysWithZeroSum(array);
    }
}
