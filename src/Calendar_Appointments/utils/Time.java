package Calendar_Appointments.utils;

public class Time {
    private int hour;
    private int minute;

    public Time(int pHour,int pMinute){
        hour = pHour;
        minute = pMinute;
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

    public String toString(){
        return "Time: " + hour + ":" + minute + ":";
    }

}