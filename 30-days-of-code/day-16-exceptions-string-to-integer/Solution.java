import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputString = in.next();

        try{
            Integer integer = Integer.valueOf(inputString);
            System.out.println(integer);
        } catch (NumberFormatException e) {
            System.out.println("Bad String");
        }

        in.close();
    }
}
