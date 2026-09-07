class Solution {
    private final int[] MONTH_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysFrom1900(date1) - daysFrom1900(date2));
    }

    private int daysFrom1900(String date) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        int days = day;

        // Add days for preceding years
        for (int y = 1900; y < year; y++) {
            days += isLeapYear(y) ? 366 : 365;
        }

        // Add days for preceding months in current year
        for (int m = 1; m < month; m++) {
            days += MONTH_DAYS[m];
            if (m == 2 && isLeapYear(year)) {
                days += 1;
            }
        }

        return days;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}