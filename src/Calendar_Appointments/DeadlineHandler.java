package Calendar_deadlines;
import Calendar_deadlines.creators.*;
import Calendar_deadlines.utils.*;

public class DeadlineHandler {
    private DateObjectCreator dateCreator = new DateObjectCreator();
    private TimeObjectCreator timeCreator = new TimeObjectCreator();
    private DeadlineObjectCreator deadlineCreator = new DeadlineObjectCreator();

    public DeadlineHandler() { }

    public Deadline createDeadlineObject(String pName, Date pDate, Time pTime) {
        deadlineCreator.setAll(pName, pDate, pTime);
        return deadlineCreator.createDeadline();
    }

    public void setDeadlineDate(Date pDate){
        deadlineCreator.setDate(pDate);
    }

    public void setDeadlineTime(Time pTime){
        deadlineCreator.setTime(pTime);
    }

    public void setDeadlineName(String pName){
        deadlineCreator.setName(pName);
    }

    public Deadline createDeadlineObject(){
        return deadlineCreator.createDeadline();
    }

    public Date createDateObject(int pDay, int pMonth, int pYear) {
        dateCreator.setAll(pDay, pMonth, pYear);
        return dateCreator.createDate();
    }

    public void setDateDay(int pDay){
        dateCreator.setDay(pDay);
    }

    public void setDateMonth(int pMonth){
        dateCreator.setMonth(pMonth);
    }

    public void setDateYear(int pYear){
        dateCreator.setYear(pYear);
    }

    public Time createTimeObject(int pHour, int pMin, int pSec) {
        timeCreator.setAll(pHour, pMin, pSec);
        return timeCreator.createTime();
    }

    public Time getLastTimeObject(){
        return timeCreator.getLast();
    }

    public Date getLastDateObject(){
        return dateCreator.getLast();
    }

    public Deadline getLastDeadlineObject(){
        return deadlineCreator.getLast();
    }



}
