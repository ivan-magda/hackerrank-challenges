import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static int B = 0;
    private static int H = 0;

    private static boolean flag = false;

    static {
        Scanner in = new Scanner(System.in);

        B = in.nextInt();
        H = in.nextInt();

        if (B <= 0 || H <= 0) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        } else {
            flag = true;
        }

        in.close();
    }

    public static void main(String[] args){
        if(flag){
            int area = B * H;
            System.out.print(area);
        }
    }

}
