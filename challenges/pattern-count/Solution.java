import java.util.Scanner;
import java.util.Stack;

public class Solution {

    private static int patternCount(String string) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        boolean isInRange = false;

        for (Character character : string.toCharArray()) {
            if (stack.empty()) {
                stack.push(character);
                if (character == '1') {
                    isInRange = true;
                }
            } else {
                Character top = stack.pop();
                stack.push(character);

                if (top == '1') {
                    isInRange = true;
                }

                if (character == '1') {
                    if (!isInRange) {
                        isInRange = true;
                    } else {
                        isInRange = false;
                        if (top == '0') count++;
                    }
                } else if (character != '0') {
                    isInRange = false;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();

        for (int i = 0; i < queries; i++) {
            String querie = in.next();
            int result = patternCount(querie);
            System.out.println(result);
        }

        in.close();
    }
}
