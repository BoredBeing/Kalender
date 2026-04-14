package Calendar_Appointments.creators;
import Calendar_Appointments.utils.Date;

public class DateObjectCreator {
    private int day = -1;
    private int month = -1;
    private int year = -1;
    private Date last = null;
    public DateObjectCreator(){}

    public void resetValues(){
        day = -1;
        month = -1;
        year = -1;
    }

    public Date[] createMonth(int pDays , int pMonth , int pYear){
        month = pMonth;year = pYear;
        Date[] currMonth = new Date[pDays];
        for(int dayofMonth = 1; dayofMonth <= pDays; dayofMonth++){
            day = dayofMonth;
            Date curr = createObject();
            currMonth[dayofMonth-1] = curr;
        }
        return currMonth;
    }

    public void setAll(int pDay, int pMonth, int pYear){
        day = pDay;
        month = pMonth;
        year = pYear;
    }

    public void setDay(int pDay){
        day = pDay;
    }

    public void setMonth(int pMonth){
        month = pMonth;
    }

    public void setYear(int pYear){
        year = pYear;
    }

    public boolean hasValues(){
        if(day != -1 && month != -1 && year != -1){
            return true;
        }
        return false;
    }

    public Date getLast(){
        return last;
    }

    public Date createDate(){
        if(hasValues()){
            last = createObject();
            resetValues();
            return last;
        }
        else {
            return null;
        }
    }

    private Date createObject(){
        Date date = new Date(day,month,year);
        return date;
    }


}
