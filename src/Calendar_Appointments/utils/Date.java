package Calendar_Appointments.utils;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int pDay, int pMonth, int pYear){
        day = pDay;
        month = pMonth;
        year = pYear;
    }

    public int getDay(){
        return day;
    }

    public void setDay(int pDay) {
        day = pDay;
    }

    public int getMonth(){
        return month;
    }

    public void setMonth(int pMonth) {
        month = pMonth;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int pYear) {
        year = pYear;
    }
}
