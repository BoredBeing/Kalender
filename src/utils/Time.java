package utils;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int pHour,int pMinute, int pSecond){
        hour = pHour;
        minute = pMinute;
        second = pSecond;
    }

    public int getHour(){
        return hour;
    }

    public int getMinute(){
        return minute;
    }

    public int getSecond(){
        return second;
    }


}