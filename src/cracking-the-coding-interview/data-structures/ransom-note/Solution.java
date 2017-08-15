import java.util.HashMap;
import java.util.Scanner;

class Solution {

    private static HashMap<String, Integer> buildMap(String[] strings) {
        HashMap<String, Integer> hashMap = new HashMap<>(strings.length);

        for (String anString : strings) {
            if (!hashMap.containsKey(anString)) {
                hashMap.put(anString, 1);
            } else {
                Integer value = hashMap.get(anString);
                hashMap.put(anString, value + 1);
            }
        }

        return hashMap;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int magazineCount = in.nextInt();
        int noteCount = in.nextInt();

        String magazine[] = new String[magazineCount];
        for (int i = 0; i < magazineCount; i++) {
            magazine[i] = in.next();
        }

        String ransom[] = new String[noteCount];
        for (int i = 0; i < noteCount; i++) {
            ransom[i] = in.next();
        }
        in.close();

        HashMap<String, Integer> magazineMap = buildMap(magazine);

        for (String ransomWord : ransom) {
            if (!magazineMap.containsKey(ransomWord)) {
                System.out.println("No");
                return;
            } else {
                Integer currentValue = magazineMap.get(ransomWord);
                if (currentValue == 0) {
                    System.out.println("No");
                    return;
                } else {
                    magazineMap.put(ransomWord, currentValue - 1);
                }
            }
        }

        System.out.println("Yes");
    }
}
