import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int countTestCases = in.nextInt();
        for (int testCase = 0; testCase < countTestCases; testCase++) {
            int rangeEnd = in.nextInt();
            int threshold = in.nextInt();
            int maxValue = Integer.MIN_VALUE;

            for (int i = 1; i <= rangeEnd; i++) {
                for (int j = 1; j <= rangeEnd; j++) {
                    if (i >= j) continue;

                    int tempBitwise = i & j;
                    if (tempBitwise < threshold && tempBitwise > maxValue) {
                        maxValue = tempBitwise;
                    }
                }
            }

            System.out.println(maxValue);
        }

        in.close();
    }
}
