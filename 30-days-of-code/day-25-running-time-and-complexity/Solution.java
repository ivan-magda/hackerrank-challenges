package com.ivanmagda;

import java.util.Scanner;

class Solution {

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }

        return true;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int countTestCases = in.nextInt();
        int[] testNumbers = new int[countTestCases];

        for (int i = 0; i < countTestCases; i++) {
            testNumbers[i] = in.nextInt();
        }
        in.close();

        for (int testNumber : testNumbers) {
            System.out.println(isPrime(testNumber) ? "Prime" : "Not prime");
        }
    }
}
