package com.ivanmagda;

public class Main {

    public static void main(String[] args) {
        boolean[][] grid = new boolean[][]{
                {true, true, true, true, true, true, true, true},
                {true, true, false, true, true, true, false, true},
                {true, true, true, true, false, true, true, true},
                {false, true, false, true, true, false, true, true},
                {true, true, false, true, true, true, true, true},
                {true, true, true, false, false, true, false, true},
                {true, false, true, true, true, false, true, true},
                {true, true, true, true, true, true, true, true}
        };

        System.out.println(IMCountPaths.countPaths(grid));
    }
}
