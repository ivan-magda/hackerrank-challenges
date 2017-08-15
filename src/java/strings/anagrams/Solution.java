import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static boolean isAnagram(String a, String b) {
        Map<Character, Integer> mapA = buildMap(a.toLowerCase());
        Map<Character, Integer> mapB = buildMap(b.toLowerCase());

        if (mapA.keySet().size() != mapB.keySet().size()) return false;
        
        for (Map.Entry<Character, Integer> entry : mapA.entrySet()) {
            if (!mapB.containsKey(entry.getKey()) || !Objects.equals(mapB.get(entry.getKey()), entry.getValue())) {
                return false;
            }
        }

        return true;
    }

    private static Map<Character, Integer> buildMap(String string) {
        Map<Character, Integer> map = new Hashtable<>(string.length());

        for (int i = 0; i < string.length(); i++) {
            Character character = string.charAt(i);
            if (!map.containsKey(character)) {
                map.put(character, 1);
            } else {
                map.put(character, map.get(character) + 1);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
