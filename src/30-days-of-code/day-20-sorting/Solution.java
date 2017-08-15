import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    /**
     * Sorts array in the ascending order.
     *
     * @param array to sort.
     * @return number of swaps operations.
     */
    private static int bubbleSort(int[] array) {
        if (array == null || array.length == 0) return 0;
        int swapsCount = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapsCount++;
                }
            }
        }

        return swapsCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int swapsCount = bubbleSort(a);
        System.out.println("Array is sorted in " + swapsCount + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }
}
