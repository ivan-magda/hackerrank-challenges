import java.io.IOException;
import java.util.Scanner;

public class Solution {
    
    private static long getMaxPrefixSum(long[] array) {
        long max = array[0];
        long currentSum = array[0];
        
        for (int i = 1; i < array.length; i++) {
            currentSum += array[i];
            
            if (currentSum > max) {
                max = currentSum;
            }
        }
        
        return max;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        long countOperations = scanner.nextInt();

        long[] array = new long[size];

        for (int i = 0; i < countOperations; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            long value = scanner.nextLong();

            array[start - 1] += value;
            
            if (end < array.length) {
                array[end] -= value;
            }
        }
        scanner.close();

        long max = getMaxPrefixSum(array);
        System.out.println(String.valueOf(max));
    }
}