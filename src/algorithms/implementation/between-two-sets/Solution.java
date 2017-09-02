import java.util.Scanner;

public class Solution {

    /**
     * Brute force solution.
     */
    private static int getTotalX(int[] a, int[] b) {
        int count = 0;

        for (int i = 1; i <= 100; i++) {
            boolean isAfactors = true;
            for (int j = 0; j < a.length && isAfactors; j++) {
                if (i % a[j] != 0) {
                    isAfactors = false;
                }
            }

            if (isAfactors) {
                boolean isFactorOfB = true;
                for (int j = 0; j < b.length && isFactorOfB; j++) {
                    if (b[j] % i != 0) {
                        isFactorOfB = false;
                    }
                }

                if (isFactorOfB) {
                    count++;
                }
            }
        }

        return count;
    }

    private static int gcd(int a, int b) {
        while (a > 0 && b > 0) {
            if (a >= b) {
                a %= b;
            } else {
                b %= a;
            }
        }

        return a + b;
    }

    private static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    /**
     * Faster, easier way.
     */
    private static int getTotalXImpoved(int[] a, int[] b) {
        int multiple = 0;
        for (int i : b) {
            multiple = gcd(multiple, i);
        }

        int factor = 1;
        for (int i : a) {
            factor = lcm(factor, i);
            if (factor > multiple) {
                return 0;
            }
        }

        if (multiple % factor != 0) {
            return 0;
        }

        int totalX = 1;

        for (int i = factor; i < multiple; i++) {
            if (multiple % i == 0 && i % factor == 0) {
                totalX++;
            }
        }

        return totalX;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        int[] b = new int[m];
        for (int b_i = 0; b_i < m; b_i++) {
            b[b_i] = in.nextInt();
        }

        in.close();

        int total = getTotalX(a, b);
        System.out.println(total);
    }
}
