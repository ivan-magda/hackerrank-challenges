import java.util.Scanner;

public class Solution {

    private static int[] getRecord(int[] scores) {
        int countBest = 0, countWorst = 0;
        int bestScore = scores[0], lowestScore = scores[0];

        for (int i = 1; i < scores.length; i++) {
            int currentScore = scores[i];

            if (currentScore > bestScore) {
                bestScore = currentScore;
                countBest++;
            }
            if (currentScore < lowestScore) {
                lowestScore = currentScore;
                countWorst++;
            }
        }

        return new int[]{countBest, countWorst};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int countGames = in.nextInt();
        int[] scores = new int[countGames];

        for (int i = 0; i < countGames; i++) {
            scores[i] = in.nextInt();
        }
        in.close();

        int[] result = getRecord(scores);

        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
    }
}
