import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static final int INPUT_ARRAY_SIZE = 6;
    private static final int HOUR_WATCH_ARR_SIZE = 3;

    private static void fillWithInput(int[][] arr) {
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        in.close();
    }

    private static int getMaxHourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i + HOUR_WATCH_ARR_SIZE <= arr.length; i++) {
            for (int j = 0; j + HOUR_WATCH_ARR_SIZE <= arr.length; j++) {
                int topSum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                int midSum = arr[i + 1][j + 1];
                int bottomSum = arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                int hourglassSum = topSum + midSum + bottomSum;

                if (max < hourglassSum) {
                    max = hourglassSum;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int arr[][] = new int[INPUT_ARRAY_SIZE][INPUT_ARRAY_SIZE];

        fillWithInput(arr);
        System.out.println(getMaxHourglassSum(arr));
    }
}
