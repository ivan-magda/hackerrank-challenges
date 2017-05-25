import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("================================");
        
            for(int i = 0; i < 3; i++){
                String s1 = sc.next();
                int x = sc.nextInt();
                
                System.out.print(s1);
                
                int whitespaceCount = 15 - s1.length();
                while (whitespaceCount-- > 0) {
                    System.out.print(" ");
                }
                
                if (x / 100 == 0) {
                    System.out.print("0");
                }
                
                if (x / 10 == 0) {
                    System.out.print("0");
                }
                
                System.out.println(x);
            }
        
            System.out.println("================================");
    }
}
