public class Main {

    private static final int DAY_PROGRAMMER = 256;

    private static String solve(int year) {
        int targetDay = DAY_PROGRAMMER;
        int month = 1;
        int daysInMonth = 0;

        while (targetDay > daysInMonth) {
            daysInMonth = getDaysInMonth(year, month);
            targetDay -= daysInMonth;
            month++;
        }

        return String.format("%02d.%02d.%d", targetDay, month, year);
    }

    private static int getDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (year == 1918) {
            return 15;
        } else if (isLeapYear(year)) {
            return 29;
        } else {
            return 28;
        }
    }

    private static boolean isLeapYear(int year) {
        return (year <= 1917 && year % 4 == 0)
                || (year >= 1919 && (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)));
    }

    public static void main(String[] args) {
        System.out.println(solve(2017));
        System.out.println(solve(2016));
        System.out.println(solve(1917));
        System.out.println(solve(1700));
    }
}
