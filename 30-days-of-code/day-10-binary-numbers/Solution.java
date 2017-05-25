import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static String getBinaryString(int decimal) {
        Stack<Integer> stack = new Stack<>();

        while (decimal > 0) {
            int reminder = decimal % 2;
            decimal /= 2;

            stack.push(reminder);
        }

        int length = stack.size();
        StringBuilder builder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            builder.append(String.valueOf(stack.pop()));
        }

        return builder.toString();
    }

    private static int maxConsecutive(final String binaryString) {
        int max = 0;
        int current = 0;
        boolean isInConsecutive = false;

        for (int i = 0; i < binaryString.length(); i++) {
            char character = binaryString.charAt(i);
            if (character == '1') {
                if (!isInConsecutive) current = 0;
                isInConsecutive = true;

                current += 1;
                if (current > max) {
                    max = current;
                }
            } else {
                isInConsecutive = false;
                current = 0;
            }
        }

        return max;
    }

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int decimal = in.nextInt();

        String binaryString = getBinaryString(decimal);
        System.out.println(maxConsecutive(binaryString));

        in.close();
    }
}
