public class Main {

    private static final int COUNT_TYPES = 5;

    private static int migratoryBirds(int length, int[] array) {
        int[] frequencies = new int[COUNT_TYPES + 1];
        int commonId = 1;

        for (int i = 0; i < length; i++) {
            int current = array[i];
            frequencies[current] += 1;

            if (frequencies[commonId] < frequencies[current]) {
                commonId = current;
            } else if (frequencies[commonId] == frequencies[current]) {
                commonId = Math.min(commonId, current);
            }
        }

        return commonId;
    }

    public static void main(String[] args) {
        System.out.println(migratoryBirds(6, new int[]{1, 4, 4, 4, 5, 3}));
    }
}
