import java.util.*;

class Solution {

    public static double[] getMedians(int[] array) {
        PriorityQueue<Integer> lowers = new PriorityQueue<>(array.length, (lhs, rhs) -> -1 * lhs.compareTo(rhs));
        PriorityQueue<Integer> highers = new PriorityQueue<>(array.length);
        double[] medians = new double[array.length];

        for (int i = 0; i < medians.length; i++) {
            int value = array[i];
            add(value, lowers, highers);
            rebalance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }

        return medians;
    }

    private static void add(int value, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.size() == 0 || value < lowers.peek()) {
            lowers.add(value);
        } else {
            highers.add(value);
        }
    }

    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        return biggerHeap.size() == smallerHeap.size()
                ? (biggerHeap.peek() + smallerHeap.peek()) / 2.0
                : biggerHeap.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int[] array = new int[count];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();

        for (double median : getMedians(array)) {
            System.out.println(String.valueOf(median));
        }
    }
}
