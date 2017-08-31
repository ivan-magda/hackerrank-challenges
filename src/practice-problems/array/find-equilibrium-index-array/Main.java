/**
 * Find equilibrium index of an array.
 * Given an array of integers, find equilibrium index in it.
 * <p>
 * Naive approach is to calculate sum of elements to the left and sum of elements to the right for each element of the array.
 * If left sub-array sum is same as right sub-array sum for an element, we print its index.
 * The time complexity of above solution is O(n^2).
 */
public class Main {

    /**
     * Function to find equilibrium index of an array.
     * <p>
     * We can solve this problem in linear time by using extra space. The idea is to create an auxiliary array left[]
     * where left[i] stores sum of elements of sub-array array[0..i-1].
     * After left[] is filled, we traverse the array from right to left and update right sub-array sum for each element encountered.
     * Now if sum of elements of left sub-array array[0..i-1] is equal to the sum of elements of right sub-array array[i+1..n)
     * for element array[i], we have found equilibrium index at i.
     */
    private static void equilibriumIndex(int array[]) {
        // left[i] stores sum of elements of sub-array array[0..i-1]
        int left[] = new int[array.length];

        left[0] = 0;

        for (int i = 1; i < array.length; i++) {
            left[i] = left[i - 1] + array[i - 1];
        }

        // right stores sum of elements of sub-array array[i+1..n)
        int right = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            // if sum of elements of sub-array array[0..i-1] is equal to
            // the sum of elements of sub-array array[i+1..n) i.e.
            // (array[0] + array[1] + .. + array[i-1]) = (array[i+1] + array[i+2] + .. + array[n-1])
            if (left[i] == right) {
                System.out.println("Equilibrium Index found at " + i);
            }

            right += array[i];
        }
    }

    /**
     * We can avoid using extra space.
     * The idea is to calculate the sum of all elements of the array.
     * Then we start from the last element of the array and maintain right sub-array sum.
     * We can calculate left sub-array sum in constant time by subtracting right sub-array sum and current element from total sum.
     */
    private static void equilibriumIndexOptimazed(int array[]) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }

        int right = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (right == sum - (array[i] + right)) {
                System.out.println("Equilibrium Index found at " + i);
            }

            right += array[i];
        }
    }

    public static void main(String[] args) {
        equilibriumIndex(new int[]{0, -3, 5, -4, -2, 3, 1, 0});
        equilibriumIndexOptimazed(new int[]{0, -3, 5, -4, -2, 3, 1, 0});
    }
}
