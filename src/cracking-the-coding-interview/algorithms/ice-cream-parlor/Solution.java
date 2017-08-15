import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

    private static int[] findChoices(int[] menu, int money) {
        int[] sorted = menu.clone();
        Arrays.sort(sorted);

        for (int i = 0; i < sorted.length; i++) {
            int complement = money - sorted[i];
            int location = Arrays.binarySearch(sorted, i + 1, sorted.length, complement);
            if (location >= 0 && location < sorted.length && sorted[location] == complement) {
                return getIndiciesFromValue(menu, sorted[i], complement);
            }
        }

        return null;
    }

    private static int[] getIndiciesFromValue(int[] menu, int value1, int value2) {
        int index1 = indexOf(menu, value1, -1);
        int index2 = indexOf(menu, value2, index1);
        return new int[]{Math.min(index1, index2), Math.max(index1, index2)};
    }

    private static int indexOf(int[] menu, int value, int excludeThis) {
        for (int i = 0; i < menu.length; i++) {
            if (value == menu[i] && i != excludeThis) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner(System.in);

        int trips = scanner.nextInt();
        for (int i = 0; i < trips; i++) {
            int money = scanner.nextInt();
            int n = scanner.nextInt();
            int costs[] = new int[n];
            for (int j = 0; j < n; j++) {
                costs[j] = scanner.nextInt();
            }

            int[] indicies = findChoices(costs, money);
            assert indicies != null;

            for (int index : indicies) {
                System.out.print(String.valueOf(index + 1) + " ");
            }
            System.out.println();
        }

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
