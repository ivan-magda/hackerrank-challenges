import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int numbersCount = in.nextInt();
        int[] numbers = new int[numbersCount];
        
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = in.nextInt();
        }
        in.close();
        
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number > 0) {
                positiveCount++;
            } else if (number < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }
        
        System.out.println((double)positiveCount / numbersCount);
        System.out.println((double)negativeCount / numbersCount);
        System.out.println((double)zeroCount / numbersCount);
    }
}
