public class Datum {

    public int year;
    public int month;
    public int day;
    public int[] data;
    public Datum between;

    public Datum(int pYear, int pMonth, int pDay) {
        year = pYear; month = pMonth; day = pDay;
        int[] temp =  {year, month, day};
        data = temp;
    }

    public Datum() {}

    public void setBetween(Datum Datum) {
        between = Datum;
    }

    public void getBetween(){

    }

    public int[] getData() {
        return data;
    }

    public String toString(){
        return year + "-" + month + "-" + day;
    }
}
