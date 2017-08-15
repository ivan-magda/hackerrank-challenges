import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    private static final String PATTERN_STRING = ".@gmail.com$";

    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);

        int countInputs = Integer.parseInt(in.nextLine());
        List<String> matchedNames = new ArrayList<>(countInputs);
        Pattern pattern = Pattern.compile(PATTERN_STRING);

        for (int i = 0; i < countInputs; i++) {
            String inputString = in.nextLine();
            Matcher matcher = pattern.matcher(inputString);

            if (matcher.find()) {
                matchedNames.add(inputString.split(" ")[0]);
            }
        }
        in.close();

        Collections.sort(matchedNames);
        for (String name : matchedNames) System.out.println(name);
    }
}
