import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static void rotateToLeft(int[] array, int rotations) {
        if (array.length > 1) {
            int lastIndex = array.length - 1;
            int[] temp = array.clone();

            for (int i = 0; i < rotations; i++) {
                int top = array[0];

                System.arraycopy(temp, 1, array, 0, array.length - 1);
                array[lastIndex] = top;
                temp = array;
            }
        }
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(String.valueOf(value) + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int rotationsCount = scanner.nextInt();

        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();

        rotateToLeft(array, rotationsCount);
        printArray(array);
    }
}
