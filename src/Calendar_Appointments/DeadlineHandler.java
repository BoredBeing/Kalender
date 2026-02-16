package Calendar_Appointments;
import Calendar_Appointments.creators.*;
import Calendar_Appointments.utils.*;

public class DeadlineHandler {
    private DeadlineObjectCreator deadlineCreator = new DeadlineObjectCreator();

    private Deadline[] currentMonth = null;
    private Deadline[] lastMonth = null;

    public DeadlineHandler() { }

    public Deadline[] loadDeadlinesForCurrMonth(int pMonth, int pYear){
       Deadline[] allDeadlines = null;
       return allDeadlines;
    }



    public void setDate(Date pDate){
        deadlineCreator.setDate(pDate);
    }


    public Deadline getLastDeadlineObject(){
        return deadlineCreator.getLast();
    }


    public DeadlineObjectCreator getDeadlineCreator(){
        return deadlineCreator;
    }



}
