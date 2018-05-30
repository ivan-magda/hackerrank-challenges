import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    private static void findTripletSumNaive(int[] array, int target) {
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (array[i] + array[j] + array[k] == target) {
                        System.out.println("Triplet is " + array[i] + " ," + array[j] + " ," + array[k]);
                    }
                }
            }
        }
    }

    private static void findTripletSumSorting(int[] array, int target) {
        Arrays.sort(array);

        int left, right;
        for (int i = 0; i < array.length - 2; i++) {
            // To find the other two elements, start two index variables
            // from two corners of the array and move them toward each other.
            left = i + 1;
            right = array.length - 1;

            while (left < right) {
                int current = array[i] + array[left] + array[right];
                if (current == target) {
                    System.out.println("Triplet is " + array[i] + " ," + array[left] + " ," + array[right]);
                    left++;
                } else if (current < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    public static void main(String[] args) {
        findTripletSumNaive(new int[]{1, 4, 45, 6, 10, 8}, 22);
        System.out.println("----------------------------------------");
        findTripletSumNaive(new int[]{-1, 0, 1, 2, -1, -4}, 0);

        System.out.println("****************************************");
        findTripletSumSorting(new int[]{1, 4, 45, 6, 10, 8}, 22);
        System.out.println("----------------------------------------");
        findTripletSumSorting(new int[]{-1, 0, 1, 2, -1, -4}, 0);
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
