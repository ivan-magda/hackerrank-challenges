import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static char[] OPEN_TOKENS = {'{', '[', '('};
    private static char[] CLOSE_TOKENS = {'}', ']', ')'};
    
    private static boolean isOpenSign(char c) {
        for (char token : OPEN_TOKENS) {
            if (token == c) {
                return true;
            }
        }
        
        return false;
    }
    
    private static boolean isCloseSign(char c) {
        for (char token : CLOSE_TOKENS) {
            if (token == c) {
                return true;
            }
        }
        
        return false;
    }

    private static boolean isMatch(char open, char close) {
        if (isOpenSign(open)) {
            switch (open) {
                case '{':
                    return close == '}';
                case '[':
                    return close == ']';
                case '(':
                    return close == ')';
                default:
                    return false;
            }
        }
        
        return false;
    }
    
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for (Character symbol : s.toCharArray()) {
            if (isOpenSign(symbol)) {
                stack.add(symbol);
            } else if (isCloseSign(symbol)) {
                if (stack.isEmpty()) {
                    return "NO";
                }
                
                char top = stack.pop();
                if (!isMatch(top, symbol)) {
                    return "NO";
                }
            } else {
                return "NO";
            }
        }
        
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }
}
