import java.io.*;
import java.util.*;

public class Solution {
    
    private static String capitalize(String string) {
        return Character.toUpperCase(string.charAt(0)) + string.substring(1);
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();
        
        int length = (A + B).length();
        System.out.println(length);
        
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
        System.out.println(capitalize(A) + " " + capitalize(B));
        
        sc.close();
    }
}
