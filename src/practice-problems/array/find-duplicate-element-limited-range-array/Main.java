/**
 * Given a limited range array of size n where array contains elements between 1 to n-1 with one element repeating,
 * find the duplicate number in it.
 */
public class Main {

    private static int hashingFindDuplicate(int[] array) {
        boolean[] visited = new boolean[array.length];

        for (int current : array) {
            if (visited[current]) {
                return current;
            }

            visited[current] = true;
        }

        return -1;
    }

    private static int xorFindDuplicate(int[] array) {
        int xor = 0;

        // Take XOR of all array elements.
        for (int anArray : array) {
            xor ^= anArray;
        }

        // Take XOR of numbers from 1 to n-1.
        for (int i = 1; i <= array.length - 1; i++) {
            xor ^= i;
        }

        // Same elements will cancel out each other as a ^ a = 0,
        // 0 ^ 0 = 0 and a ^ 0 = a.

        // XOR will contain the missing number.
        return xor;
    }

    public static void main(String[] args) {
        int[] hashing = {1, 2, 3, 4, 4};
        System.out.println("Duplicate: " + String.valueOf(hashingFindDuplicate(hashing)));

        int[] xor = {1, 4, 3, 4, 5, 2};
        System.out.println("Duplicate: " + String.valueOf(xorFindDuplicate(xor)));
    }
}
