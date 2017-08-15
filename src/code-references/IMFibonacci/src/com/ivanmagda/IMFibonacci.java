package com.ivanmagda;

public class IMFibonacci {

    private IMFibonacci() {
    }

    public static int recursively(int number) {
        if (number <= 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        }

        return recursively(number - 1) + recursively(number - 2);
    }

    public static int recursivelyWithMemorization(int number) {
        return recursivelyWithMemorization(number, new int[number + 1]);
    }

    private static int recursivelyWithMemorization(int number, int[] memo) {
        if (number <= 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        }

        if (memo[number] == 0) {
            memo[number] = recursivelyWithMemorization(number - 1, memo) + recursivelyWithMemorization(number - 2, memo);
        }

        return memo[number];
    }

    public static int iterative(int number) {
        int a = 0;
        int b = 1;
        int current = 0;

        for (int i = 2; i <= number; i++) {
            current = a + b;
            a = b;
            b = current;
        }

        return current;
    }
}
