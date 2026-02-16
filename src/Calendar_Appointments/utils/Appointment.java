package Calendar_deadlines.utils;

public class Appointment {


    private Date date = null;
    private Time time = null;
    private String name;
    private boolean bookmark = false;
    private Date[] archive = new Date[8];
    private boolean archiveFull = false;

    public Appointment(String pName){
        name = pName;
        bookmark = true;
    }


    public Appointment(Date pDate, Time pTime, String pName){
        setDate(pDate);
        time = pTime;
        name = pName;
    }

    public Date[] getArchive(){
        return archive;
    }

    public boolean isBookmark(){
        return bookmark;
    }

    public String getName(){
        return name;
    }

    public Time getTime(){
        return time;
    }

    public Date getDate(){
        return date;
    }

    public void setTime(Time pTime){
        time = pTime;
    }

    public void setBookmark(boolean pBool){
        bookmark = pBool;
    }

    public void setDate(Date pDate){
        //archiving up to 16 last appointment records idk wanted to have that info
        if(date != null && !archiveFull) {
            for(int i = 0;i<archive.length;i++) {
                if(archive[i] != null) continue;
                if(i==archive.length-1) archiveFull = true;
                archive[i] = date;
                break;
            }
        }

        date = pDate;
    }

}





