package Calendar_utils;

public class Date{

    public int year;
    public int month;
    public int day;
    public int[] data;
    public Date between = null;

    public Date(int pYear, int pMonth, int pDay) {
        year = pYear; month = pMonth; day = pDay;
        int[] temp =  {year, month, day};
        data = temp;
    }

    public Date() {}

    public void setBetween(Date pDate) {
        between = pDate;
    }

    public Date getBetween(){
        return between;
    }

    public int[] getData() {
        return data;
    }

    public String toString(){
        return year + "-" + month + "-" + day;
    }
}
