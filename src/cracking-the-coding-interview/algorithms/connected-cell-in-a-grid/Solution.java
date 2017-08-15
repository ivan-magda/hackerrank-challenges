import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static int getBiggestRegion(int[][] array) {
        int[][] matrix = array.clone();
        int max = 0;
        
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] == 1) {
                    int currentSize = getRegionSize(matrix, row, column);
                    max = Math.max(max, currentSize);
                }
            }
        }
        
        return max;
    }
    
    private static int getRegionSize(int[][] matrix, int row, int column) {
        if (row < 0 || column < 0 || row >= matrix.length || column >= matrix[0].length) {
            return 0;
        } else if (matrix[row][column] == 0) {
            return 0;
        }
        
        matrix[row][column] = 0;
        int size = 1;
        
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = column - 1; c <= column + 1; c++) {
                if (r != row || c != column) {
                    size += getRegionSize(matrix, r, c);
                }
            }
        }
        
        return size;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];

        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

        in.close();

        System.out.println(getBiggestRegion(grid));
    }
}
