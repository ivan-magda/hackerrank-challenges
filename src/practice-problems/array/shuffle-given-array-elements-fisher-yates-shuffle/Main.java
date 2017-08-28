import java.util.Arrays;
import java.util.Random;

/**
 * Shuffle a given array of elements (Fisher–Yates shuffle).
 * <p>
 * Given an array of integers, in-place shuffle it.
 * The algorithm should produce an unbiased permutation i.e. every permutation is equally likely.
 */
public class Main {

    /**
     * Fisher–Yates shuffle is used to generate random permutations.
     * It takes time proportional to the number of items being shuffled and shuffles them in place.
     */
    private static void shuffle(int[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            Random random = new Random();
            int j = random.nextInt(i + 1);
            swap(array, i, j);
        }
    }

    private static void swap(int[] array, int lhs, int rhs) {
        int temp = array[lhs];
        array[lhs] = array[rhs];
        array[rhs] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffle(array);

        System.out.println(Arrays.toString(array));
    }
}
