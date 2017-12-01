public class Main {

    private static int bonAppetit(int n, int k, int billCharged, int[] ar) {
        int sharedCost = 0;

        for (int i = 0; i < n; i++) {
            if (i != k) {
                sharedCost += ar[i];
            }
        }

        int billActual = sharedCost / 2;

        return billActual == billCharged ? 0 : billCharged - billActual;
    }

    public static void main(String[] args) {
        int resRefund = bonAppetit(4, 1, 12, new int[]{3, 10, 2, 9});
        System.out.println(resRefund == 0 ? "Bon Appetit" : String.valueOf(resRefund));

        int resOk = bonAppetit(4, 1, 7, new int[]{3, 10, 2, 9});
        System.out.println(resOk == 0 ? "Bon Appetit" : String.valueOf(resOk));
    }
}
