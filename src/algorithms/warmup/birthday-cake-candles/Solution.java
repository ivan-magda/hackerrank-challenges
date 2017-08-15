import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int candlesCount = in.nextInt();
        int[] candleHeights = new int[candlesCount];
        int maxHeight = Integer.MIN_VALUE;

        for (int i = 0; i < candleHeights.length; i++) {
            int height = in.nextInt();
            candleHeights[i] = height;

            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        in.close();

        int countBlowOut = 0;
        for (int candleHeight : candleHeights) {
            if (candleHeight == maxHeight) countBlowOut++;
        }

        System.out.println(countBlowOut);
    }
}
