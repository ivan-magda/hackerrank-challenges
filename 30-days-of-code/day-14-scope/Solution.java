import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
    private int[] elements;
    public int maximumDifference;

    Difference(int[] elements) {
        this.elements = elements;
    }

    void computeDifference() {
        for (int i = 0; i < this.elements.length; i++) {
            for (int j = i; j < this.elements.length; j++) {
                int absDif = Math.abs(this.elements[i] - this.elements[j]);
                if (absDif > this.maximumDifference) {
                    this.maximumDifference = absDif;
                }
            }
        }
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}
