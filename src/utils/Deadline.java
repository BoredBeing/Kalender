package utils;

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
