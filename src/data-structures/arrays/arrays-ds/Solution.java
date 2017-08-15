import java.io.*;
import java.util.*;

public class Solution {

    private static void printReverse(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int size = in.nextInt();
        int[] array = new int[size];
        
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        in.close();
        
        printReverse(array);
    }
}
