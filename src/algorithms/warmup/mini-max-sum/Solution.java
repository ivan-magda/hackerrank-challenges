import java.util.Scanner;

class Solution {

    private static final int NUMBERS_COUNT = 5;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long[] numbers = new long[NUMBERS_COUNT];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = in.nextLong();
        }
        in.close();

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            long currentSum = 0;

            for (int j = 0; j < numbers.length; j++) {
                if (i == j) continue;
                currentSum += numbers[j];
            }

            if (currentSum > max) {
                max = currentSum;
            }
            if (currentSum < min) {
                min = currentSum;
            }
        }

        System.out.println(String.valueOf(min) + " " + String.valueOf(max));
    }
}
