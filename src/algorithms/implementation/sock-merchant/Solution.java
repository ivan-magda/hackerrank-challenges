import java.util.HashSet;

public class Main {

    private static int sockMerchant(int length, int[] array) {
        int result = 0;
        HashSet<Integer> set = new HashSet<>(array.length);

        for (int item : array) {
            if (set.contains(item)) {
                set.remove(item);
                result++;
            } else {
                set.add(item);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(sockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));
    }
}
