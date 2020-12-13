public class Date {
    private int day;
    private int month;
    private int year;
    private int weekDay;


    public Date(int day,int month,int year, int weekDay){
        this.day = day;
        this.month = month;
        this.year = year;
        this.weekDay = weekDay;
    }
    public Date(){

    }

    public int getDay(){
        return  day;
    }
    public void setDay(int day){
        this.day = day;
    }

    public int getMonth(){
        return  month;
    }
    public void setMonth(int month){
        this.month = month;
    }

    public int getYear(){
        return  year;
    }
    public void setYear(int year){
        this.year = year;
    }

    public int getWeekDay(){
        return  weekDay;
    }
    public void setWeekDay(int weekDay){
        this.weekDay = weekDay;
    }

    public String weekDayToString (){
        return switch (weekDay) {
            case 0 -> "MONDAY";
            case 1 -> "TUESDAY";
            case 2 -> "WEDNESDAY";
            case 3 -> "THURSDAY";
            case 4 -> "FRIDAY";
            case 5 -> "SATURDAY";
            case 6 -> "SUNDAY";
            default -> "INCORRECT VALUE";
        };
    }
}
