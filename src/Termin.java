
public class Termin {


    private Datum date;
    private String name;
    private boolean bookmark = false;
    private boolean changed = false;
    private Datum[] archive = new Datum[16];

    public Termin(String pName){
        name = pName;
        bookmark = true;
    }

    public Termin(int pYear, int pMonth, int pDay, String pName){
        name = pName;
        changed = true;
        changeTime(pYear, pMonth, pDay);
    }

    public void setTime(int pYear, int pMonth, int pDay){
        if(bookmark) {
            bookmark = false;
        }
    }

    public void changeTime(int pYear, int pMonth, int pDay){
        changed = false;
        //archiving up to 16 last appointment records idk wanted to have that info
        if(date != null) {
            for(int i = 0;i<archive.length;i++) {
                if(archive[i] != null) continue;
                archive[i] = date;
                break;
            }
        }

        date = new Datum(pYear, pMonth, pDay);

    }

    public int[] getDate(){
        return date.data;
    }

    public String toString(){
        return(name+":"+date.toString());
    }

    public static void main(String[] args){
        Termin t = new Termin(2000,1,1,"first");

        System.out.println((t.archive[0]== null));
        t.changeTime(2000,1,2);
        System.out.println(t.archive[0].toString());
    }
}





