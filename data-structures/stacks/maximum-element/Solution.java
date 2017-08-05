import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static final int QUERY_TYPE_PUSH = 1;
    private static final int QUERY_TYPE_DELETE = 2;
    private static final int QUERY_TYPE_MAX = 3;

    private static int findMax(Stack<Integer> stack) {
        int max = Integer.MIN_VALUE;

        for (Integer value : stack) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();
        Integer max = Integer.MIN_VALUE;

        for (int i = 0; i < queries; i++) {
            int queryType = scanner.nextInt();

            switch (queryType) {
                case QUERY_TYPE_PUSH:
                    int newValue = scanner.nextInt();
                    stack.push(newValue);

                    if (newValue > max) {
                        max = newValue;
                    }

                    break;
                case QUERY_TYPE_DELETE:
                    Integer top = stack.pop();
                    if (Objects.equals(top, max)) {
                        max = findMax(stack);
                    }
                    break;
                case QUERY_TYPE_MAX:
                    System.out.println(String.valueOf(max));
                    break;
                default:
                    break;
            }
        }
        
        scanner.close();
    }
}
