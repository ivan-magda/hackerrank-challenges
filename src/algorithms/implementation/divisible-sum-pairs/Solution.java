public class Main {

    private static int divisibleSumPairs(int length, int modulo, int[] array) {
        int res = 0;

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((array[i] + array[j]) % modulo == 0) {
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(divisibleSumPairs(6, 3, new int[]{1, 3, 2, 6, 1, 2}));
    }
}
