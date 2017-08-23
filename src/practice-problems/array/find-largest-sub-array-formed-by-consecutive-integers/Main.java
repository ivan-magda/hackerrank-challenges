/**
 * Given an array of integers, find largest sub-array formed by consecutive integers.
 * The sub-array should contain all distinct values.
 */
public class Main {

    /**
     * Function to check if sub-array A[i..j] is formed by consecutive integers.
     */
    private static boolean isConsecutive(int[] array, int i, int j, int min, int max) {
        // In order for an array to contain consecutive integers, the diff
        // between maximum and element element in it should be exactly j - i.
        if (max - min != j - i) {
            return false;
        }

        boolean[] visited = new boolean[j - i + 1];

        // Traverse the sub-array and checks if each element appears only ones.
        for (int k = i; k <= j; k++) {
            if (visited[array[k] - min]) {
                return false;
            }

            visited[array[k] - min] = true;
        }

        return true;
    }

    private static void findMaxSubArray(int[] array) {
        int length = 1;
        int start = 0, end = 0;

        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i], max = array[i];
            for (int j = i + 1; j < array.length; j++) {
                min = Math.min(min, array[j]);
                max = Math.max(max, array[j]);

                if (isConsecutive(array, i, j, min, max) && (length < max - min + 1)) {
                    length = max - min + 1;
                    start = i;
                    end = j;
                }
            }
        }

        System.out.println("The largest sub-array is [" + start + ", " + end + "]");
    }

    public static void main(String[] args) {
        int[] array = {2, 0, 2, 1, 4, 3, 1, 0};
        findMaxSubArray(array);
    }
}
