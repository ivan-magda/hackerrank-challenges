import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    private static long countWays(int value, int values[]) {
        long[] table = new long[value + 1];
        table[0] = 1;

        for (int anValue : values) {
            for (int j = anValue; j <= value; j++) {
                table[j] += table[j - anValue];
            }
        }

        return table[value];
    }

    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner(System.in);

        int value = scanner.nextInt();
        int count = scanner.nextInt();
        int[] values = new int[count];

        for (int i = 0; i < count; i++) {
            values[i] = scanner.nextInt();
        }

        System.out.println(countWays(value, values));

        scanner.close();
    }

    private static class FastScanner {
        BufferedReader bufferedReader;
        StringTokenizer tokenizer;

        FastScanner(InputStream stream) {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        void close() throws IOException {
            bufferedReader.close();
        }
    }
}
