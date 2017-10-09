import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static void sort(String[] array) {
        Arrays.sort(array, (lhs, rhs) -> {
            int lhsLength = lhs.length();
            int rhsLength = rhs.length();

            if (lhsLength == rhsLength) {
                return lhs.compareTo(rhs);
            }

            return lhsLength - rhsLength;
        });
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        String[] unsorted = new String[n];
        
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        in.close();
        
        sort(unsorted);
        for (String string : unsorted) {
            System.out.println(string);
        }
    }
}
