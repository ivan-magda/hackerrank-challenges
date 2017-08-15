import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String inputString = in.nextLine();
        int substringLength = in.nextInt();

        in.close();

        List<String> substrings = new ArrayList<>(inputString.length());
        for (int i = 0, end = substringLength; end <= inputString.length(); i++, end = i + substringLength) {
            substrings.add(inputString.substring(i, end));
        }

        if (substrings.size() <= 0) return;
        
        String min = substrings.get(0);
        String max = substrings.get(0);
        for (int i = 1; i < substrings.size(); i++) {
            String currentString = substrings.get(i);
            if (currentString.compareTo(min) < 0) {
                min = currentString;
            } else if (currentString.compareTo(max) > 0) {
                max = currentString;
            }
        }
        
        System.out.println(min);
        System.out.println(max);
    }
}
