

public class Kalender {

    String absPath = "D:/Projects/Kalender/CalenderDates/";
    String BufferSubPath = "Buffer/";
    String BookmarkSubPath = "Bookmark/";
    String dateSubPath = "Dates/";
    String[] menuActions = {"select","list","date","next"};
    String[] selectActions = {"year","month","week","day"};
    int[] testdata = {2,4,5,9,12,19,24,30};
    int currMonth = -1;
    int currYear = 2025;
    int[] daysOfMonths;
    Termin[] tempStorage = new Termin[10];
    String[] correspondingMonths = {"Januar","Februar","März","April","Mai","Juni","Juli","August","September","October","November","December"};
    String[] weekDays = {"Mo","Di","Mi","Do","Fr","Sa","So"};
    FileManager fm;

    public Kalender() {
        fm = new FileManager(this);
        refreshYear();
    }

    public Kalender(int year){
        fm = new FileManager(this);
        currYear = year;
    }
    public static void main(String[] args) {
        Kalender k = new Kalender();
        FileManager fm = k.fm;


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

    public void createAppointment(int year, int month, int day, String name) {
        Termin appointment;
        appointment = new Termin(year,month,day,name);
        for(int i = 0;i<tempStorage.length;i++){
            if(tempStorage[i] == null){
                tempStorage[i] = appointment;
                break;
            }
        }
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
                    hasAppointment = hasAppointment(date) ? "A" : "";
                    System.out.print(date+"\t"+hasAppointment+"|");
                }
                System.out.println();
            }
            else
            {
                for(int j = 1;j<=7;j++) {
                    date = i*7+j;
                    hasAppointment = hasAppointment(date) ? "A" : "";
                    System.out.print(date+"\t"+hasAppointment+"|");
                }
                System.out.println();
            }
        }

    }

    public boolean hasAppointment(int day) {
        for(int appointmentDay: testdata){
            if(day == appointmentDay){
                return true;
            }
        }
        return false;
    }

    public static boolean isLeapYear(int year) {
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) return true;
        return false;
    }

    public void menuAction(){

    }

}