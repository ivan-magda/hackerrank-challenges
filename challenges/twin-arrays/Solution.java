import java.util.Scanner;

public class Solution {

    static int twinArrays(int[] ar1, int[] ar2) {
        assert ar1.length == ar2.length;

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < ar1.length; i++) {
            for (int j = 0; j < ar2.length; j++) {
                if (i == j) continue;

                int currentSum = ar1[i] + ar2[j];
                if (currentSum < minSum) {
                    minSum = currentSum;
                }
            }
        }

        return minSum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arraySize = in.nextInt();

        int[] array1 = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array1[i] = in.nextInt();
        }

        int[] array2 = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array2[i] = in.nextInt();
        }

        int result = twinArrays(array1, array2);
        System.out.println(result);
    }
}
