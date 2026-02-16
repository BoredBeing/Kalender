package Calendar_Appointments.creators;
import Calendar_Appointments.utils.Date;
import Calendar_Appointments.utils.Deadline;
import Calendar_Appointments.utils.Time;

public class DeadlineObjectCreator {
    private String name = "";
    private Date date = null;
    private Time time = null;
    private Deadline last = null;

    public DeadlineObjectCreator(){}

    public void resetValues(){
        name = "";
        date = null;
        time = null;
    }

    public void setAll(String pName, Date pDate, Time pTime){
        name = pName;
        date = pDate;
        time = pTime;
    }

    public void setTime(Time pTime){
        time = pTime;
    }

    public void setDate(Date pDate){
        date = pDate;
    }

    public void setName(String pName){
        name = pName;
    }

    public boolean hasValues(){
        if(time != null && date != null && name.equals("")== false){
            return true;
        }
        return false;
    }

    public Deadline createDeadline(){
        if(hasValues()==true){
            last = createObject();
            return last;
        }
        else{
            return null;
        }
    }

    private Deadline createObject(){
        Deadline deadline = new Deadline(name,date,time);
        return deadline;
    }

    public Deadline getLast(){
        return last;
    }

}
