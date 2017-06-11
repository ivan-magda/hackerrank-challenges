import java.util.Random;

class Solution {

    private static final int MIN_LECTURES_COUNT = 1;
    private static final int MAX_LECTURES_COUNT = 5;
    private static final int MIN_STUDENTS_COUNT = 3;
    private static final int MAX_STUDENTS_COUNT = 200;

    private static final double MAX_ARRIVE_TIME = Math.pow(10, 3);
    private static final double MIN_ARRIVE_TIME = MAX_ARRIVE_TIME * -1;

    private static final Random random = new Random();

    private static int getRandomIntInBounds(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    private static int[] generateRandomArray(int length, int min, int max) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = getRandomIntInBounds(min, max);
        }

        return array;
    }

    private static boolean isExcludeThreshold(int[] arriveTimes, int threshold) {
        for (int k = 0, count = 0; k < arriveTimes.length; k++) {
            if (arriveTimes[k] < threshold) {
                count++;
            }

            if (count >= threshold) {
                return true;
            }
        }

        return false;
    }

    private static void printArray(int[] array) {
        for (int anArray : array) {
            System.out.print(String.valueOf(anArray) + " ");
        }
        System.out.println("");
    }

    public static void main(String args[]) {
        for (int i = 0; i < 5; i++) {
            int lecturesCount = getRandomIntInBounds(MIN_LECTURES_COUNT, MAX_LECTURES_COUNT);

            System.out.println(lecturesCount);

            for (int j = 0; j < lecturesCount; j++) {
                int studentsCount = getRandomIntInBounds(MIN_STUDENTS_COUNT, MAX_STUDENTS_COUNT);
                int cancellationThreshold = getRandomIntInBounds(1, studentsCount);

                System.out.println(String.valueOf(studentsCount) + " " + String.valueOf(cancellationThreshold));

                int[] arriveTimes = generateRandomArray(studentsCount, (int) MIN_ARRIVE_TIME, (int) MAX_ARRIVE_TIME);
                printArray(arriveTimes);

                System.out.println(isExcludeThreshold(arriveTimes, cancellationThreshold) ? "YES" : "NO");
            }
        }
    }
}
