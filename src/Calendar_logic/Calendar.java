package Calendar_logic;

import Calendar_Appointments.creators.*;
import Calendar_Appointments.utils.*;


public class Calendar {

    String absPath = "/home/Tobi/Boring_Projects/java/Calender";
    String BufferSubPath = "Buffer/";
    String BookmarkSubPath = "Bookmark/";
    String dateSubPath = "Dates/";
    String[] menuActions = {"select","list","date","next"};
    String[] selectActions = {"year","month","week","day"};
    int[] testdata = {2,4,5,9,12,19,24,30};
    int currMonth = -1;
    int currYear = 2025;
    int[] daysOfMonths;
    String[] correspondingMonths = {"Januar","Februar","März","April","Mai","Juni","Juli","August","September","October","November","December"};
    String[] weekDays = {"Mo","Di","Mi","Do","Fr","Sa","So"};

    private DateObjectCreator dateCreator = new DateObjectCreator();
    private Date selected = null;
    FileManager fm;

    public Calendar() {
        fm = new FileManager(this);
        refreshYear();
    }

    public Calendar(int year){
        fm = new FileManager(this);
        currYear = year;
    }
    public static void main(String[] args) {
        Calendar k = new Calendar();
        k.nextMonth();

    }

    public Date selectDate(int pDay){
        if(hasDayInCurrMonth(pDay)) {
            dateCreator.setAll(pDay, currMonth, currYear);
            selected = dateCreator.createDate();
            return selected;
        }
        return null;
    }

    public boolean hasDayInCurrMonth(int pDay){
        if(pDay <= getDaysInCurrMonth()){
            return true;
        }
        return false;
    }

    public int getDaysInCurrMonth(){
        if(currMonth <= -1 || currMonth > 11){
            System.out.println("Calendar not correctly initialized");
            return -1;
        }
        return daysOfMonths[currMonth];
    }

    public void refreshYear() {
        int[] temp =  {31, isLeapYear(currYear)? 29:28 , 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        daysOfMonths = temp;
    }

    public void previousMonth() {
        if(currMonth > 0){
            currMonth--;
        }
        else {
            currMonth = 11;
            currYear--;
            refreshYear();
            System.out.println("Current Year: " + currYear);
        }
        displayCalenderMonth(currMonth);
    }



    public void nextMonth() {
        if(currMonth == -1){
            System.out.println("Current Year: "+currYear);
        }
        if (currMonth < 11) {
            currMonth++;
        }
        else{
            currMonth = 0;
            currYear++;
            refreshYear();
            System.out.println("Current Year: " + currYear);
        }

        displayCalenderMonth(currMonth);
    }


    public void displayCalenderMonth(int month) {
        if (month < 0 || month > 11) {
            return;
        }

        int daysToDisplay = daysOfMonths[month];
        int weeks = (int)daysToDisplay / 7;
        int over = daysToDisplay % 7;

        System.out.println(correspondingMonths[month]+":");
        //System.out.println("Es gibt " + weeks + " wochen und " + over + "tage über");
        System.out.println();

        for(int i = 0;i<=weeks;i++) {
            int date;
            String hasAppointment;
            if(i == weeks){
                for(int j = 1;j<=over;j++) {
                    date = i*7+j;
                    //hasAppointment = hasAppointment(date) ? "A" : "";
                    hasAppointment = "";
                    System.out.print(date+"\t"+hasAppointment+"|");
                }
                System.out.println();
            }
            else
            {
                for(int j = 1;j<=7;j++) {
                    date = i*7+j;
                    //hasAppointment = hasAppointment(date) ? "A" : "";
                    hasAppointment = "";
                    System.out.print(date+"\t"+hasAppointment+"|");
                }
                System.out.println();
            }
        }

    }


    public static boolean isLeapYear(int year) {
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) return true;
        return false;
    }

    public void menuAction(){

    }

}