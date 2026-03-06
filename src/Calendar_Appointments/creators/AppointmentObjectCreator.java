package Calendar_Appointments.creators;
import Calendar_Appointments.utils.*;

public class AppointmentObjectCreator {

    private Date date = null;
    private Time time = null;
    private String name = "";
    private Appointment last = null;


    public AppointmentObjectCreator(){

    }

    public void resetValues(){
        date = null;
        time = null;
        name = "";

    }

    public boolean hasValues(){
        if(date != null && time != null && !name.isEmpty()){
            return true;
        }
        return false;
    }

    public Appointment createAppointment(){
        if(hasValues()){
            last = createObject();
            return last;
        }
        return null;
    }



    public void setAll(Date pDate,Time pTime, String pName){
        date = pDate;
        time = pTime;
        name = pName;
    }

    public void setDate(Date pDate){
        date = pDate;
    }

    public void setTime(Time pTime){
        time = pTime;
    }

    public void setName(String pName){
        name = pName;
    }

    //todo find a good implementation idea preferrably not at 4 am like rn
    private Appointment createBookmarkObject(){
        return new Appointment(name);
    }

    private Appointment createObject(){
        return new Appointment(date,time,name);
    }

    public Appointment getLast(){
        return last;
    }

}
