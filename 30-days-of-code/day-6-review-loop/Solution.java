import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testsCount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < testsCount; i++) {
            String inputString = scanner.nextLine();

            String even = "";
            String odd = "";
            
            for (int j = 0; j < inputString.length(); j++) {
                char currentChar = inputString.charAt(j);
                if (j % 2 == 0) {
                    even += currentChar;
                } else {
                    odd += currentChar;
                }
            }
            
            System.out.println(even + " " + odd);
        }
        
        scanner.close();
    }
}
