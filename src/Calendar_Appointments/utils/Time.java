package Calendar_Appointments.utils;

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

    public void setHour(int pHour){
        hour = pHour;
    }

    public int getMinute(){
        return minute;
    }

    public void setMinute(int pMin){
        minute = pMin;
    }

    public int getSecond(){
        return second;
    }

    public void setSecond(int pSec) {
        second = pSec;
    }

}