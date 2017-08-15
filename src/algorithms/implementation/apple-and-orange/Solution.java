import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static class Range {
        int start;
        int end;
        
        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    private static boolean isInRange(Range range, int point) {
        return point >= range.start && point <= range.end;
    }
    
    private static int countApples(int[] apples, int start, Range range) {
        int count = 0;
        
        for (int i = 0; i < apples.length; i++) {
            int point = start + apples[i];
            if (isInRange(range, point)) {
                count++;
            }
        }
        
        return count;
    }
    
    private static int countOranges(int[] oranges, int start, Range range) {
        int count = 0;
        
        for (int i = 0; i < oranges.length; i++) {
            int point = start + oranges[i];
            if (isInRange(range, point)) {
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
        
        in.close();
        
        Range range = new Range(s, t);
        System.out.println(String.valueOf(countApples(apple, a, range)));
        System.out.println(String.valueOf(countOranges(orange, b, range)));
    }
}
