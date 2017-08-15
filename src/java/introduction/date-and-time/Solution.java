import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

class Main {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);

        int month = Integer.valueOf(in.next());
        int day = Integer.valueOf(in.next());
        int year = Integer.valueOf(in.next());

        in.close();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, day);
        calendar.set(Calendar.YEAR, year);

        System.out.println(new SimpleDateFormat("EEEE").format(calendar.getTime()).toUpperCase());
    }
}
