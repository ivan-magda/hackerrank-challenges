import java.util.Arrays;

public class Main {

    private static void reorder(int[] array) {
        int copyIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[copyIndex++] = array[i];
            }
        }

        for (int i = copyIndex; i < array.length; i++) {
            array[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 0, 5, 0, 1, 0, 6, 0};
        reorder(array);
        System.out.println(Arrays.toString(array));
    }
}
