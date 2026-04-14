package Calendar_logic;

import Calendar_Appointments.creators.DateObjectCreator;
import Calendar_Appointments.utils.Date;

public class DateHandler {

    public DateObjectCreator dateCreator = new DateObjectCreator();
    public Date currDate = null;

    public DateHandler(){

    }

    public void setCurrDate(Date pDate){
        currDate = pDate;
    }

    public Date getCurrDate(){
        return currDate;
    }



    public int parseStringToInt(String pString) {
        return Integer.parseInt(pString);
    }
}
