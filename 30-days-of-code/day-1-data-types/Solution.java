import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
		
        Scanner scan = new Scanner(System.in);
        /* Declare second integer, double, and String variables. */
        int integerInput = scan.nextInt();
        double doubleInput = scan.nextDouble();
        String stringInput = "";

        /* Print the sum of both integer variables on a new line. */
        System.out.println(i + integerInput);

        /* Print the sum of the double variables on a new line. */
        System.out.println(d + doubleInput);
		
        /* Concatenate and print the String variables on a new line; 
        	the 's' variable above should be printed first. */
        while (scan.hasNext()) stringInput += scan.next() + " ";
        System.out.println(s + stringInput);

        scan.close();
    }
}
