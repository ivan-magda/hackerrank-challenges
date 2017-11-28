public class Main {

    private static int solve(int length, int[] values, int targetSum, int targetConsecutiveItems) {
        int res = 0;

        for (int i = 0; i < length && (i + targetConsecutiveItems - 1 < length); i++) {
            int sum = 0;
            int countConsecutive = 1;
            for (int j = i; countConsecutive <= targetConsecutiveItems && j < length; j++, countConsecutive++) {
                sum += values[j];
                if (sum == targetSum && countConsecutive == targetConsecutiveItems) {
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("Res = " + solve(5, new int[]{1, 2, 1, 3, 2}, 3, 2));
        System.out.println("Res = " + solve(6, new int[]{1, 1, 1, 1, 1, 1}, 3, 2));
        System.out.println("Res = " + solve(1, new int[]{4}, 4, 1));
    }
}
