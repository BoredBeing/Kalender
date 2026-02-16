package Calendar_deadlines.creators;
import Calendar_deadlines.utils.Date;

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
            return last;
        }
        else {
            return null;
        }
    }

    public Date createObject(){
        Date date = new Date(day,month,year);
        return date;
    }


}
