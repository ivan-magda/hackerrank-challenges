import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static final int DEFAULT_LINES_COUNT = 10;

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);

        int linesCount = 0;
        List<String> lines = new ArrayList<>(DEFAULT_LINES_COUNT);

        while (in.hasNext()) {
            lines.add(in.nextLine());
            linesCount++;
        }

        for (int i = 0; i < linesCount; i++) {
            System.out.println((i + 1) + " " + lines.get(i));
        }

        in.close();
    }
}
