import java.util.HashMap;
import java.util.Scanner;

class Solution {

    private static int numberNeeded(String first, String second) {
        int count = 0;

        HashMap<Character, Integer> firstMap = buildStringMap(first);
        HashMap<Character, Integer> secondMap = buildStringMap(second);

        for (HashMap.Entry<Character, Integer> entry : firstMap.entrySet()) {
            int value = entry.getValue();
            Character key = entry.getKey();

            if (secondMap.containsKey(key)) {
                int secondValue = secondMap.get(key);
                if (value != secondValue) {
                    count += Math.abs(value - secondValue);
                }
            } else {
                count += value;
            }

            secondMap.remove(key);
        }

        for (HashMap.Entry<Character, Integer> entry : secondMap.entrySet()) {
            int value = entry.getValue();
            count += value;
        }

        return count;
    }

    private static HashMap<Character, Integer> buildStringMap(String string) {
        HashMap<Character, Integer> hashMap = new HashMap<>(string.length());

        for (Character character : string.toCharArray()) {
            if (!hashMap.containsKey(character)) {
                hashMap.put(character, 1);
            } else {
                Integer currentValue = hashMap.get(character);
                hashMap.put(character, ++currentValue);
            }
        }

        return hashMap;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String lhsString = in.next();
        String rhsString = in.next();
        in.close();

        System.out.println(numberNeeded(lhsString, rhsString));
    }
}
