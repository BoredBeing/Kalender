package Calendar_logic;
import Calendar_Appointments.creators.*;
import Calendar_Appointments.utils.*;

public class DeadlineHandler {
    private DeadlineObjectCreator deadlineCreator = new DeadlineObjectCreator();
    private Deadline currentDeadline = null;

    public DeadlineHandler() { }

    public boolean setCurrentDeadline(Deadline pDeadline){
        if(currentDeadline != null) return false;
        currentDeadline = pDeadline;
        return true;
    }

    public void createDeadlineFromSelectedDate(Date pDate){
        deadlineCreator.setDate(pDate);

    }

    public void setCurrentDeadlineName(String pName){
        if(currentDeadline != null){
            currentDeadline.setName(pName);
        }
        else{
            System.out.println("no current Deadline detected");
        }
    }

    public void setCurrentDeadlineDate(Date pDate){
        if(currentDeadline != null){
           currentDeadline.setDate(pDate);
        }
        else{
            System.out.println("no current Deadline detected");
        }
    }

    public void setCurrentDeadlineTime(Time pTime){
        if(currentDeadline != null){
            currentDeadline.setTime(pTime);
        }
        else{
            System.out.println("no current Deadline detected");
        }
    }

    public Deadline createDeadline(String pName, Date pDate, Time pTime){
        deadlineCreator.setAll(pName,pDate,pTime);
        currentDeadline= deadlineCreator.createDeadline();
        deadlineCreator.resetValues();
        return currentDeadline;
    }



    public Deadline getLastDeadlineObject(){
        return deadlineCreator.getLast();
    }


    public DeadlineObjectCreator getDeadlineCreator(){
        return deadlineCreator;
    }



}
