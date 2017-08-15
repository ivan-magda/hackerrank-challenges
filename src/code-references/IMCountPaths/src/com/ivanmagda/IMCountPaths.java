package com.ivanmagda;

public class IMCountPaths {

    private IMCountPaths() {
    }

    // Count paths recursively.

    public static int recursively(boolean[][] grid) {
        return countRecursively(grid, 0, 0);
    }

    private static int countRecursively(boolean[][] grid, int row, int col) {
        if (!isValidSquare(grid, row, col)) {
            return 0;
        } else if (isAtEnd(grid, row, col)) {
            return 1;
        }

        return countRecursively(grid, row + 1, col) + countRecursively(grid, row, col + 1);
    }

    // Count paths recursively with memorization approach.

    public static int withMemorization(boolean[][] grid) {
        return countWithMemo(grid, 0, 0, new int[grid.length][grid[0].length]);
    }

    private static int countWithMemo(boolean[][] grid, int row, int col, int[][] paths) {
        if (!isValidSquare(grid, row, col)) {
            return 0;
        } else if (isAtEnd(grid, row, col)) {
            return 1;
        }

        if (paths[row][col] == 0) {
            paths[row][col] = countWithMemo(grid, row + 1, col, paths) + countWithMemo(grid, row, col + 1, paths);
        }

        return paths[row][col];
    }

    // Utility methods.

    private static boolean isValidSquare(boolean[][] grid, int row, int col) {
        return grid[row][col];
    }

    private static boolean isAtEnd(boolean[][] grid, int row, int col) {
        return row == grid.length - 1 || col == grid[0].length - 1;
    }
}
