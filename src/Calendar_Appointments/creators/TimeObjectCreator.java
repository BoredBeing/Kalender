package Calendar_deadlines.creators;
import Calendar_deadlines.utils.Time;

public class TimeObjectCreator {
    private int hour = -1;
    private int minute = -1;
    private int second = -1;
    private Time last = null;

    public TimeObjectCreator(){}

    public void resetValues(){
        hour = -1;
        minute = -1;
        second = -1;
    }

    public void setAll(int pHour, int pMinute, int pSecond){
        hour = checkHour(pHour);
        minute = checkMinute(pMinute);
        second = checkSecond(pSecond);
    }

    public void setHour(int pHour){
        hour = checkHour(pHour);
    }

    public void setMinute(int pMinute){
        minute = checkMinute(pMinute);
    }

    public void setSecond(int pSecond){
        second = checkSecond(pSecond);
    }

    public int checkHour(int pHour){
        if(pHour >= 0 && pHour < 24){
            return pHour;
        }
        return -1;
    }

    public int checkMinute(int pMin){
        if(pMin >= 0 && pMin < 60){
            return pMin;
        }
        return -1;
    }

    public int checkSecond(int pSec){
        return checkMinute(pSec);
    }

    public boolean hasValues(){
        if(hour != -1 && minute != -1 && second != -1){
            return true;
        }
        return false;
    }

    public String valueFinder(){
        String result = "Problems found in ";
        if(hour == -1){
            result += "hour ";
        }
        if(minute == -1){
            result += "minute ";
        }
        if(second == -1){
            result += "second";
        }

        return result;
    }

    public Time getLast(){
        return last;
    }

    public Time createTime(){
        if(hasValues()){
            last = createObject();
            return last;
        }
        else{
            return null;
        }
    }

    private Time createObject(){
        Time time = new Time(hour,minute,second);
        return time;
    }

}
