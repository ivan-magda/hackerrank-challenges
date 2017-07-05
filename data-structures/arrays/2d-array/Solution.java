import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static final int OFFSET = 3;

    private static int getMaxHourglassSum(int[][] a) {
        int rows = a.length - OFFSET;
        int columns = a[0].length - OFFSET;
        
        int sum = Integer.MIN_VALUE;
        
        for(int i = 0; i <= rows; i++){
            for(int j = 0; j <= columns; j++){
                int current = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+1] + a[i+2][j] + a[i+2][j+1] + a[i+2][j+2];
                if (current > sum) {
                    sum = current;
                }
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }
        
        in.close();
        
        System.out.println(getMaxHourglassSum(arr));
    }
}
