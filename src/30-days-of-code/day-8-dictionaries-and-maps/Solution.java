import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution{
    
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        Map<String, Integer> map = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            String name = in.next();
            int phone = in.nextInt();

            map.put(name, phone);
        }

        while (in.hasNext()) {
            String inputName = in.next();

            if (map.containsKey(inputName)) {
                System.out.println(inputName + "=" + map.get(inputName));
            } else {
                System.out.println("Not found");
            }
        }

        in.close();
    }
}
