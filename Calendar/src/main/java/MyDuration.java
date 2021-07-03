public class MyDuration {
    /**
     *
     * @param date
     * @param currDate
     * @return how many years was date (from currDate)
     */
    public static long inYears(Date date, Date currDate) {
        if (date.getMonth() <= currDate.getMonth()) {
            return currDate.getYear() - date.getYear();
        } else {
            return currDate.getYear() - date.getYear() - 1;
        }
    }

    /**
     *
     * @param date
     * @param currDate
     * @return number of months between dates
     */
    public static long inMonths(Date date, Date currDate) {
        return ((currDate.getYear() - date.getYear()) * 12 - date.getMonth() + currDate.getMonth());
    }

    /**
     *
     * @param date
     * @param currDate
     * @return number of days between dates
     */
    public static long inDays(Date date, Date currDate) {
        long days = 0;
        for (int i = currDate.getYear() - date.getYear(); i > 0; i--)
            if (MyCalendar.isLeapYear(date.getYear())) {
                days += 366;
            } else {
                days += 365;
            }

        for (int k = date.getMonth() - 1; k > 0; k--) {
            days -= MyCalendar.getNumberOfDaysInMonth(k, date.getYear());
        }
        days += date.getDay();

        for (int j = currDate.getMonth() - 1; j > 0; j--) {
            days += MyCalendar.getNumberOfDaysInMonth(j, currDate.getYear());
        }
        days += currDate.getDay();

        return days;
    }

}
