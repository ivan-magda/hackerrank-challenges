import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static List<List<String>> groupAnagramsBySort(String[] strings) {
        if (strings == null || strings.length == 0) {
            return null;
        }

        Map<String, List<String>> groups = new HashMap<>();

        for (String string : strings) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }

            groups.get(key).add(string);
        }

        return new ArrayList<>(groups.values());
    }

    private static List<List<String>> groupAnagramsByCount(String[] strings) {
        if (strings == null || strings.length == 0) {
            return null;
        }

        Map<String, List<String>> groups = new HashMap<>();
        int[] count = new int[26];

        for (String string : strings) {
            Arrays.fill(count, 0);
            for (char c : string.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder stringBuilder = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                stringBuilder.append("#");
                stringBuilder.append(count[i]);
            }

            String key = stringBuilder.toString();

            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }

            groups.get(key).add(string);
        }

        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagramsBySort(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagramsByCount(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    final String line = br.readLine();
                    if (line == null || line.length() == 0) {
                        return null;
                    } else {
                        st = new StringTokenizer(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
