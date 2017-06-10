import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class Solution {

    private static final int NO_HACKOS_FINE = 0;
    private static final int DAY_HACKOS_FINE = 15;
    private static final int MONTH_HACKOS_FINE = 500;
    private static final int YEAR_HACKOS_FINE = 10000;

    private static Calendar buildFrom(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, date);

        return calendar;
    }

    private static int calculateFine(Calendar returnedCalendar, Calendar expectedCalendar) {
        Date returnedDate = returnedCalendar.getTime();
        Date expectedDate = expectedCalendar.getTime();

        int returnedMonth = returnedCalendar.get(Calendar.MONTH);
        int expectedMonth = expectedCalendar.get(Calendar.MONTH);

        if (returnedDate.compareTo(expectedDate) <= 0) {
            return NO_HACKOS_FINE;
        } else if (returnedCalendar.get(Calendar.YEAR) > expectedCalendar.get(Calendar.YEAR)) {
            return YEAR_HACKOS_FINE;
        } else if (returnedMonth > expectedMonth) {
            return MONTH_HACKOS_FINE * (returnedMonth - expectedMonth);
        }

        int returnedDay = returnedCalendar.get(Calendar.DAY_OF_MONTH);
        int expectedDay = expectedCalendar.get(Calendar.DAY_OF_MONTH);

        return DAY_HACKOS_FINE * (returnedDay - expectedDay);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        Calendar returnedCalendar = null;
        Calendar expectedCalendar = null;

        for (int i = 0; i < 2; i++) {
            int date = in.nextInt();
            int month = in.nextInt();
            int year = in.nextInt();
            if (i == 0) {
                returnedCalendar = buildFrom(year, month, date);
            } else {
                expectedCalendar = buildFrom(year, month, date);
            }
        }
        in.close();

        assert returnedCalendar != null && expectedCalendar != null;

        System.out.println(calculateFine(returnedCalendar, expectedCalendar));
    }
}
