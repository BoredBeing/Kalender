package Calendar_Appointments.utils;

public class Deadline {
    private Date date;
    private Time time;
    private String name;

    public Deadline(String pName, Date pDate, Time pTime){
        name = pName;
        date = pDate;
        time = pTime;
    }

    public Deadline(){}

    public String getName(){
        return name;
    }

    public Date getDate(){
        return date;
    }

    public Time getTime(){
        return time;
    }

    public String[] getData() {
        String[] temp = {name,date.toString(),time.toString()};
        return temp;
    }

    public void setName(String pName){
        name = pName;
    }

    public void setDate(Date pDate){
        date = pDate;
    }

    public void setTime(Time pTime){
        time = pTime;
    }
}
