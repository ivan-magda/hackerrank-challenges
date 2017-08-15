import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();

        String reversed = new StringBuilder(string).reverse().toString();
        System.out.println(string.equals(reversed) ? "Yes" : "No");
        
        sc.close();
    }
}
