package com.ivanmagda;

public class Main {

    private static long sumOfMultiples(int limit) {
        return sum(limit, 3) + sum(limit, 5) - sum(limit, 3 * 5);
    }

    private static long sum(int limit, int number) {
        long size = ((limit - 1) / number);
        return number * size * (size + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(String.valueOf(sumOfMultiples(n)));
        }
        in.close();
    }
}
