package Calendar_logic;

import Calendar_Appointments.creators.TimeObjectCreator;
import Calendar_Appointments.utils.Time;

public class TimeHandler {

    public TimeObjectCreator timeCreator = new TimeObjectCreator();


    public TimeHandler() {
        reserTimeCreator();
    }

    public void reserTimeCreator() {
        timeCreator.setAll(12,0,0);
    }

    public void output(String pMessage) {
        System.out.println(pMessage);
    }



    public Time confirmCreation(){
        Time object = timeCreator.createTime();
        return object;
    }

    public boolean manualSetHour(String pHour) {
        int parameter =  parseStringToInt(pHour);
        timeCreator.setHour(parameter);
        return (timeCreator.getHour() != -1);
    }

    public boolean manualSetMinute(String pMin){
        int parameter = parseStringToInt(pMin);
        timeCreator.setMinute(parameter);
        return (timeCreator.getMinute() != -1);
    }



    public int parseStringToInt(String pString) {
        return Integer.parseInt(pString);

    }




}
