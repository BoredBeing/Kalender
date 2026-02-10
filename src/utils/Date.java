package utils;

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

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }
}
