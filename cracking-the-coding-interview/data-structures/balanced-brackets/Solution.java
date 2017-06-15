import java.util.Scanner;
import java.util.Stack;

class Solution {

    private static final char[][] TOKENS = {{'{', '}'}, {'[', ']'}, {'(', ')'}};

    private static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char character : expression.toCharArray()) {
            if (isOpenTerm(character)) {
                stack.push(character);
            } else if (stack.isEmpty() || !isMatch(stack.pop(), character)) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOpenTerm(char character) {
        for (char[] array : TOKENS) {
            if (array[0] == character) return true;
        }

        return false;
    }

    private static boolean isMatch(char openTerm, char closeTerm) {
        for (char[] array : TOKENS) {
            if (array[0] == openTerm && array[1] == closeTerm) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.next());
        for (int i = 0; i < t; i++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }

        in.close();
    }
}
