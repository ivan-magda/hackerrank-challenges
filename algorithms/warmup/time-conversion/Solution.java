import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);

        String timeString = null;
        if (in.hasNextLine()) {
            timeString = in.nextLine();
        }
        in.close();

        if (timeString == null) {
            throw new Exception("Time string is null");
        }

        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ssa");
        Date parsedDate = dateFormat.parse(timeString);

        DateFormat dateFormat24 = new SimpleDateFormat("HH:mm:ss");
        System.out.println(dateFormat24.format(parsedDate));
    }
}
