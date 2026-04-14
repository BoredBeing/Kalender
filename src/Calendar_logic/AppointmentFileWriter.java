package Calendar_logic;

import Calendar_Appointments.creators.*;
import Calendar_Appointments.utils.*;

import java.util.Scanner;

public class AppointmentFileWriter {

    Scanner sc;
    int currMonth = -1;
    int currYear = -1;
    Date[] currentOutput;
    Date selected;
    FileManager fm = new FileManager();
    Calendar calendar = new Calendar();
    AppointmentObjectCreator appointmentCreator = new AppointmentObjectCreator();
    TimeHandler timeHandler = new TimeHandler();
    DateHandler dateHandler = new DateHandler();

    public AppointmentFileWriter(){
        currentOutput = calendar.nextMonth();
    }

    public static void main(String[] args){
        AppointmentFileWriter dfw = new AppointmentFileWriter();
        dfw.action();
    }

    public String getInput(String pMessage) {
        sc = new Scanner(System.in);
        System.out.println(pMessage);
        String input = sc.nextLine();
        return input;
    }

    public void setAllAppointmentValues(){
        appointmentCreator.setName(getInput("What Name shall your appointment have?"));
        setAllTimeValues();
        appointmentCreator.setDate(selectDate(getInput("What Date should be selected")));

    }

    public void setAllTimeValues(){
        timeHandler.manualSetHour(getInput("Stunde(Format: HH)"));
        timeHandler.manualSetMinute(getInput("Minute(Format: MM)"));
    }

    public Time createManualTime(){
        if(timeHandler.timeCreator.hasValues()){
            return timeHandler.confirmCreation();
        }
        setAllTimeValues();
        return timeHandler.confirmCreation();
    }

    public void setCurrMonth(String month){
        currMonth = Integer.parseInt(month);
        currentOutput =  calendar.getMonth(currMonth);
    }

    public void getPreviousMonth(){
        currentOutput = calendar.previousMonth();
    }

    public void getNextMonth(){
        currentOutput = calendar.nextMonth();
    }

    public Date selectDate(String pNumber) {
        int number = Integer.parseInt(pNumber);
        if(number > currentOutput.length) {
            System.out.println("number out of reach");

        }
        return currentOutput[number-1];
    }

    public Appointment createAppointment(){
        if(appointmentCreator.hasValues()) {
            return appointmentCreator.createAppointment();
        }
        setAllAppointmentValues();
        return appointmentCreator.createAppointment();

    }



    public boolean action() {
        String input;
        do{
            input = getInput("choose action!!");
            if(input.equalsIgnoreCase("next")){
                getNextMonth();
            }
            if(input.equalsIgnoreCase("previous")){
                getPreviousMonth();
            }
            if(input.equalsIgnoreCase("select")){
                Date test;
                //if(test != null) System.out.println(test.toString());
            }
            if(input.equalsIgnoreCase("change")){
                setCurrMonth(getInput("What month to change to? (month-1)"));
                calendar.displayCalenderMonth(currMonth);
            }
            if(input.equalsIgnoreCase("appointment")){
                Date selected = selectDate(getInput("Select Date please"));
                System.out.println(selected.toString());

            }

        }while(!input.equalsIgnoreCase("exit"));
        System.out.println("Out of while loop after exit");
        return false;
    }

}
