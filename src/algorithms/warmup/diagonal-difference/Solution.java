import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int matrixSize = in.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int value = in.nextInt();
                matrix[i][j] = value;
            }
        }
        in.close();

        int rightDiagonalSum = 0;
        int leftDiagonalSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            int leftIdx = (matrix.length - 1) - i;

            rightDiagonalSum += matrix[i][i];
            leftDiagonalSum += matrix[i][leftIdx];
        }
        int absDiagonalDiff = Math.abs(rightDiagonalSum - leftDiagonalSum);

        System.out.println(absDiagonalDiff);
    }
}
