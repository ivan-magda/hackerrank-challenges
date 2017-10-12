import java.util.*;
public class Solution {
    
    static void partition(int[] ar) {
        int pivot = ar[0]; 
        int countEqual = 1;
        
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] < pivot) {
                left.add(ar[i]);
            } else if (ar[i] == pivot) {
                countEqual++;
            } else {
                right.add(ar[i]);
            }
        }
        
        int i = 0;
        for (int value : left) {
            ar[i++] = value;
        }
        
        for (int j = 0; j < countEqual; j++) {
            ar[i++] = pivot;
        }
        
        for (int value : right) {
            ar[i++] = value;
        }
    }
    
    static void swap(int[] ar, int lhs, int rhs) {
        int temp = ar[lhs];
        ar[lhs] = ar[rhs];
        ar[rhs] = temp;
    }
 
    static void printArray(int[] ar) {
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
           partition(ar);
          printArray(ar);
       }    
   }
