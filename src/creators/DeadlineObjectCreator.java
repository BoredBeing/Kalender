package creators;
import utils.Date;
import utils.Deadline;
import utils.Time;

public class DeadlineObjectCreator {
    private String name = "";
    private Date date = null;
    private Time time = null;

    public DeadlineObjectCreator(){}

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
            return createObject();
        }
        else{
            return null;
        }
    }

    private Deadline createObject(){
        Deadline deadline = new Deadline(name,date,time);
        return deadline;
    }

}
