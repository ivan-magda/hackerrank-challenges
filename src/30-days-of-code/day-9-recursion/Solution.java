import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static int factorial(int number) {
        if (number <= 1) {
            return 1;
        }

        return number * factorial(number - 1);
    }

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int inputValue = in.nextInt();

        System.out.println(factorial(inputValue));

        in.close();
    }
}
