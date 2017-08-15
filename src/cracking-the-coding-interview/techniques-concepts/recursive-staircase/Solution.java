import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        for (int i = 0; i < count; i++) {
            int height = in.nextInt();
            System.out.println(countPathIterative(height));
        }

        in.close();
    }

    // Recursive approach.

    private static int countPathsRecursive(int steps) {
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        }

        return countPathsRecursive(steps - 1) + countPathsRecursive(steps - 2) + countPathsRecursive(steps - 3);
    }

    // Recursion with memorization.

    private static int countPathWithMemory(int steps) {
        return countPathWithMemory(steps, new int[steps + 1]);
    }

    private static int countPathWithMemory(int steps, int[] memo) {
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        }

        if (memo[steps] == 0) {
            memo[steps] = countPathWithMemory(steps - 1, memo) + countPathWithMemory(steps - 2, memo) + countPathWithMemory(steps - 3, memo);
        }

        return memo[steps];
    }

    // Dynamic Programming approach.

    private static int countPathDP(int steps) {
        if (steps < 0) {
            return 0;
        } else if (steps <= 1) {
            return 1;
        }

        int[] memo = new int[steps + 1];
        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 2;

        for (int i = 3; i <= steps; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }

        return memo[steps];
    }

    private static int countPathIterative(int steps) {
        if (steps < 0) {
            return 0;
        } else if (steps <= 1) {
            return 1;
        }

        int[] paths = {1, 1, 2};
        for (int i = 3; i <= steps; i++) {
            int currentCount = paths[2] + paths[1] + paths[0];

            paths[0] = paths[1];
            paths[1] = paths[2];
            paths[2] = currentCount;
        }

        return paths[2];
    }
}
