import java.util.Arrays;

public class Main {

    private static void threeWayPartition(int[] array) {
        final int PIVOT = 1;

        int start = 0, mid = 0;
        int end = array.length - 1;
        int temp;

        while (mid <= end) {
            if (array[mid] < PIVOT) {
                temp = array[start];
                array[start] = array[mid];
                array[mid] = temp;

                start++;
                mid++;
            } else if (array[mid] > PIVOT) {
                temp = array[mid];
                array[mid] = array[end];
                array[end] = temp;

                end--;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 0, 0, 1, 1, 0, 0, 2};
        System.out.println("Unsorted :" + Arrays.toString(array));

        threeWayPartition(array);
        System.out.println("Sorted: " + Arrays.toString(array));
    }
}
