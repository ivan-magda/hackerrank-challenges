import java.io.*;
import java.util.*;

public class Solution {
    
    private static class Pair {
        public int a;
        public int b;
        
        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(N);
        String[] temp = br.readLine().split(" ");
        
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(temp[i]));
        }
        
        Collections.sort(list);
        
        //Find the minimum absolute difference
        List<Pair> pairs = new ArrayList<>();
        int mindiff = Integer.MAX_VALUE;
        
        for (int i = 1; i < N; i++){
            int a = list.get(i);
            int b = list.get(i-1);
            
            int diff = a - b;
            diff = (diff < 0) ? -diff : diff;
            
            if (diff < mindiff){
                mindiff = diff;
                pairs.clear();
                pairs.add(new Pair(b, a));
            } else if (diff == mindiff){
                pairs.add(new Pair(b, a));
            }
        }

        for (Pair p : pairs){
            System.out.print(p.a + " " + p.b + " ");
        }
    }
}
