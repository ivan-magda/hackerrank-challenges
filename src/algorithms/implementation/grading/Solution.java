import java.util.*;

public class Solution {

    private static final int MAX_GRADE = 100;
    private static final int MIN_GRADE = 0;
    private static final int MIN_ROUND_GRADE = 38;
    private static final int MIN_ROUND_DIFF = 3;
    private static final int ROUND_OFFSET_NUMBER = 5;

    private static int[] roundGrades(int[] grades) {
        int[] rounded = grades.clone();

        for (int i = 0; i < grades.length; i++) {
            int current = grades[i];

            if (current < MIN_ROUND_GRADE) {
                continue;
            }

            int nextRounded = nextRoundOfFive(current);
            int diff = nextRounded - current;

            if (diff < MIN_ROUND_DIFF) {
                rounded[i] = nextRounded;
            }
        }

        return rounded;
    }

    private static int nextRoundOfFive(int number) {
        int result = number;

        while (result++ <= MAX_GRADE) {
            if (result % ROUND_OFFSET_NUMBER == 0) {
                return result;
            }
        }

        return Math.min(result, MAX_GRADE);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int countQueries = in.nextInt();
        int[] grades = new int[countQueries];

        for (int i = 0; i < countQueries; i++) {
            grades[i] = in.nextInt();
        }
        in.close();

        int[] result = roundGrades(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
    }
}
