package Calendar_logic;

import Calendar_Appointments.creators.AppointmentObjectCreator;
import Calendar_Appointments.utils.*;

public class AppointmentHandler {

    private AppointmentObjectCreator appointmentCreator = new AppointmentObjectCreator();
    private Appointment currentAppointment = null;

    public AppointmentHandler(){

    }


    public void setCurrentAppointment(Appointment pAppointment){
        currentAppointment = pAppointment;
    }

    public Appointment getCurrent(){
        return currentAppointment;
    }

    public void setCurrentAppointmentDate(Date pDate){
        if(currentAppointment != null){
            currentAppointment.setDate(pDate);
        }
        else{
            System.out.println("No Current Appointment in Handler found ");
        }
    }

    public void setCurrentAppointmentTime(Time pTime){
        if(currentAppointment != null){
            currentAppointment.setTime(pTime);
        }
        else {
            System.out.println("No current Apppointment in Handler found");
        }
    }

    public void setCurrentAppointmentName(String pName){
        if(currentAppointment != null){
            currentAppointment.setName(pName);
        }
    }

    public Appointment getCurrentAppointment(){
        return currentAppointment;
    }

}
