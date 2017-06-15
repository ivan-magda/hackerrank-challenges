import java.util.Scanner;

class Solution {

    private static int lonelyInteger(int[] values) {
        int result = 0;

        for (int value : values) {
            result ^= value;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfIntegers = scanner.nextInt();
        int[] values = new int[numberOfIntegers];

        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.println(lonelyInteger(values));
    }
}
