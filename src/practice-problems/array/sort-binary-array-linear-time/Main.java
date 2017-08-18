import java.util.Arrays;

/**
 * Given an binary array, sort it in linear time and constant space.
 * Output should print contain all zeroes followed by all ones.
 */
public class Main {

    private static void sortBinaryArrayNaive(int[] array) {
        int countZeros = 0;
        for (int anArray : array) {
            if (anArray == 0) {
                countZeros++;
            }
        }

        int i = 0;
        while (countZeros-- != 0) {
            array[i++] = 0;
        }

        while (i < array.length) {
            array[i++] = 1;
        }
    }

    private static void sortBinaryArrayInsertion(int[] array) {
        int insertIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[insertIndex++] = 0;
            }
        }

        while (insertIndex < array.length) {
            array[insertIndex++] = 1;
        }
    }

    private static void sortBinaryArrayWithPartitioning(int[] array) {
        final int PIVOT = 1;

        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] < PIVOT) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] binaryArrayNaive = {0, 1, 0, 0, 0, 1, 0, 1, 1, 0};
        sortBinaryArrayNaive(binaryArrayNaive);
        System.out.println(Arrays.toString(binaryArrayNaive));

        int[] binaryArrayInsertion = {0, 1, 0, 0, 0, 1, 0, 1, 1, 0};
        sortBinaryArrayInsertion(binaryArrayInsertion);
        System.out.println(Arrays.toString(binaryArrayInsertion));

        int[] binaryArrayPartition = {0, 1, 0, 0, 0, 1, 0, 1, 1, 0};
        sortBinaryArrayWithPartitioning(binaryArrayPartition);
        System.out.println(Arrays.toString(binaryArrayPartition));
    }
}
