import java.util.*;
public class Solution {
    
    private static final int MAX_VALUE = 100;
    
    private static int[] countAppears(int[] array) {
        int[] counts = new int[MAX_VALUE];
        
        for (int value : array) {
            counts[value]++;
        }
        
        return counts;
    }
    
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
       
      public static void main(String[] args) {
          Scanner in = new Scanner(System.in);
          int n = in.nextInt();
          int[] ar = new int[n];
          
          for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
          }
          in.close();
          
          printArray(countAppears(ar));
       }    
   }
