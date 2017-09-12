import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Find majority element in an array (Boyer–Moore majority vote algorithm).
 * <p>
 * Given an array of integers containing duplicates, return the majority element in an array if present.
 * A majority element appears more than n/2 times where n is the size of the array.
 */
public class Main {

    /**
     * Function to return majority element present in given array using naive approach.
     */
    private static int findMajorityElementNaive(int[] array) {
        for (int i = 0; i <= array.length / 2; i++) {
            int count = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == array[i]) {
                    count++;
                }
            }

            if (count > array.length / 2) {
                return array[i];
            }
        }

        return -1;
    }

    /**
     * Function to return majority element present in given array using hashing.
     */
    public static int findMajorityElementHashing(int[] array) {
        Map<Integer, Integer> map = new HashMap<>(array.length);

        for (int element : array) {
            map.putIfAbsent(element, 0);
            map.put(element, map.get(element) + 1);
        }

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if ((int) pair.getValue() > array.length / 2) {
                return (int) pair.getKey();
            }

            it.remove();
        }

        return -1;
    }

    /**
     * Function to return majority element present in given array using Boyer Moore vote algorithm.
     */
    public static int findMajorityElementBoyerMoore(int[] array) {
        int majorityElement = -1;
        int counter = 0;

        for (int element : array) {
            // If the counter counter becomes 0, we set the current candidate
            // to current element and reset the counter to 1.
            if (counter == 0) {
                majorityElement = element;
                counter = 1;
            }
            // If the counter is not 0, we increment or decrement the counter
            // according to whether current element is the current candidate.
            else if (majorityElement == element) {
                counter++;
            } else {
                counter--;
            }
        }

        return majorityElement;
    }


    public static void main(String[] args) {
        int[] array = {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2};

        System.out.println("Majority naive: " + String.valueOf(findMajorityElementNaive(array)));
        System.out.println("Majority hashing: " + String.valueOf(findMajorityElementHashing(array)));
        System.out.println("Majority Boyer Moore: " + String.valueOf(findMajorityElementBoyerMoore(array)));
    }
}
