/**
 * Find index of 0 to be replaced to get maximum length sequence of continuous ones.
 */
public class Main {

    // Find index of 0 to replaced with 1 to get maximum sequence
    // of continuous 1's
    private static int findIndexOfZero(int[] array) {
        int maxIdx = -1;

        for (int i = 0, prevZeroIdx = -1, count = 0, maxCount = 0; i < array.length; i++) {
            if (array[i] == 1) {
                count++;
            } else {
                count = i - prevZeroIdx;
                prevZeroIdx = i;
            }

            if (count > maxCount) {
                maxCount = count;
                maxIdx = prevZeroIdx;
            }
        }

        return maxIdx;
    }

    public static void main(String[] args) {
        int array[] = {0, 0, 1, 0, 1, 1, 1, 0, 1, 1};
        int index = findIndexOfZero(array);

        if (index != -1) {
            System.out.print("Index to be replaced is " + index);
        } else {
            System.out.print("Invalid input");
        }
    }
}
