package com.ivanmagda;

public class IMCountPaths {

    private IMCountPaths() {
    }

    public static int countPaths(boolean[][] grid) {
        return countPaths(grid, 0, 0);
    }

    private static int countPaths(boolean[][] grid, int row, int col) {
        if (!isValidSquare(grid, row, col)) {
            return 0;
        }

        if (isAtEnd(grid, row, col)) {
            return 1;
        }

        return countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1);
    }

    private static boolean isValidSquare(boolean[][] grid, int row, int col) {
        return grid[row][col];
    }

    private static boolean isAtEnd(boolean[][] grid, int row, int col) {
        return row == grid.length - 1 || col == grid[0].length - 1;
    }
}
