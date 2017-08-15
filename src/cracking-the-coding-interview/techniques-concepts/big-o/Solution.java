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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int primalityCount = in.nextInt();
        int[] array = new int[primalityCount];

        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }
        in.close();

        for (int number : array) {
            System.out.println(isPrime(number) ? "Prime" : "Not prime");
        }
    }
}
