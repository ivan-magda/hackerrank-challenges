import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {

    private static List<Integer> rotatedToLeft(int[] array, int rotations) {
        LinkedList<Integer> linkedList = new LinkedList<>(
                Arrays.stream(array).boxed().collect(Collectors.toList())
        );

        for (int i = 0; i < rotations; i++) {
            Integer first = linkedList.removeFirst();
            linkedList.addLast(first);
        }

        return Arrays.asList(linkedList.toArray(new Integer[linkedList.size()]));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int arraySize = in.nextInt();
        int leftRotationsCount = in.nextInt();
        int array[] = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            array[i] = in.nextInt();
        }

        List<Integer> rotatedList = rotatedToLeft(array, leftRotationsCount);

        for (Integer number : rotatedList) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
