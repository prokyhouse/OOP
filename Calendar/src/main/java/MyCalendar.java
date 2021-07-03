
import static java.lang.StrictMath.abs;

public class MyCalendar {
    /**
     *
     * @param year If it is divisible by 400, hence the year is a leap year
     * @return true or false
     */
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else
                return true;
        } else
            return false;
    }

    /**
     * @param month which number of days we want to know
     * @param year to know is that year leap or not
     * @return
     */
    public static int getNumberOfDaysInMonth(int month, int year) {
        if (isLeapYear(year) && (month == 2)) {
            return 29;
        } else {
            return (int) (28 + (month + Math.floor(month / 8.)) % 2 + 2 % month + 2 * Math.floor(1. / month));
        }
    }

    /**
     *
     * @param currDate
     * @param weeks
     * @return Date is (currDate + weeks)
     */
    public static Date plusWeeks(Date currDate, int weeks) {
        return plusDays(currDate, weeks * 7);
    }
    public static Date minusWeeks(Date currDate,int weeks) {return minusDays(currDate,weeks * 7);}

    public static Date plusDays(Date currDate, int days) {
        Date resultDate = new Date(currDate.getDay() + days,currDate.getMonth(),
                currDate.getYear(),(currDate.getWeekDay() + days) % 7);

        while (resultDate.getDay() > getNumberOfDaysInMonth(resultDate.getMonth(), resultDate.getYear())) {
            if (resultDate.getMonth() == 12) {
                resultDate.setYear(resultDate.getYear()+1);
                resultDate.setDay(resultDate.getDay() - getNumberOfDaysInMonth(resultDate.getMonth(), resultDate.getYear()));
                resultDate.setMonth(resultDate.getMonth()+1);
                int buff = -1;
                buff = resultDate.getMonth() ;
                buff %= 12;
                resultDate.setMonth(buff);
            } else {
                resultDate.setDay(resultDate.getDay() - getNumberOfDaysInMonth(resultDate.getMonth(), resultDate.getYear()));
                resultDate.setMonth(resultDate.getMonth()+1);
            }
        }
        return resultDate;
    }

    /**
     *
     * @param currDate
     * @param days
     * @return result, which is (currDate + days)
     */
    public static Date minusDays(Date currDate, int days) {
        Date resultDate = new Date(currDate.getDay() - days + 1,
                                        currDate.getMonth(),
                                        currDate.getYear(),
                                        7 + (currDate.getWeekDay() - days) % 7);

        while (resultDate.getDay() <= 0) {
            if (resultDate.getMonth() == 1) {
                resultDate.setYear(resultDate.getYear() - 1);
                resultDate.setDay(resultDate.getDay() + getNumberOfDaysInMonth(resultDate.getMonth(), resultDate.getYear()));
                resultDate.setMonth(12);
            } else {
                resultDate.setDay(resultDate.getDay() + getNumberOfDaysInMonth(resultDate.getMonth(), resultDate.getYear()));
                resultDate.setMonth(resultDate.getMonth()-1);
            }
        }
        return resultDate;
    }

    /**
     *
     * @param date our current day
     * @param day is param. of searching
     * @param weekday is also param. of searching
     * @return Date that satis. our papams
     */
    public static Date nearestDay(Date date, int day, int weekday) {
        while (date.getDay() != day || date.getWeekDay() != weekday) date = plusDays(date, 1);
        return date;
    }


}
