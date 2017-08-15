import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static int countOccurrences(List<String> list, String string) {
        int count = 0;

        for (String anString : list) {
            if (anString.equals(string)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int countStrings = scanner.nextInt();
        List<String> strings = new ArrayList<>(countStrings);

        for (int i = 0; i < countStrings; i++) {
            strings.add(scanner.next());
        }

        int queries = scanner.nextInt();
        for (int i = 0; i < queries; i++) {
            String queryString = scanner.next();
            System.out.println(countOccurrences(strings, queryString));
        }

        scanner.close();
    }
}
