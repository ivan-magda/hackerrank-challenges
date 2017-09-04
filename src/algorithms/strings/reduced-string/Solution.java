import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String super_reduced_string(String s){
        char[] remains = new char[s.length()];
        int top = -1;
        
        for (char c: s.toCharArray())
            if (top < 0 || c != remains[top]) {
                remains[++top] = c;
            } else {
                --top;
            }
        
        return top < 0 ? "Empty String" : new String(remains, 0, top+1);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
