import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileManager{

    Kalender kalender;
    String path;
    String bufferSubPath;
    String bookmarkSubPath;
    String dateSubPath;
    Termin[] currProcesses = new Termin[10];
    int processingIndex = 0;
    Termin currProcess = null;

    public static void main(String[] args){
        Kalender k = new Kalender();
        FileManager fm = k.fm;
        k.createAppointment(2025, 7, 0, "test");
        String path = fm.getRelativPathForCurrentProcess(k.tempStorage[0]);
        System.out.println(fm.checkIfPathExists(fm.dateSubPath + path));
    }

    public FileManager(Kalender pKalender) {
        System.out.println("FileManager started:");
        kalender = pKalender;
        path = pKalender.absPath;
        bufferSubPath = path + kalender.BufferSubPath;
        bookmarkSubPath = path + kalender.BookmarkSubPath;
        dateSubPath = path + kalender.dateSubPath;

    }

    public int addProcess(Termin pTermin) {
        if(currProcesses[processingIndex] == null) {
            currProcesses[processingIndex] = pTermin;
            return processingIndex;
        }
        int i = 0;
        do {
            i++;
            if (((currProcesses.length - 1) >= processingIndex + i )&&(currProcesses[processingIndex+i] == null)) {
                currProcesses[processingIndex + i] = pTermin;
                return (processingIndex + i);
            }
        }while(i!=currProcesses.length-1);
        return(-1);
    }

    public void initializeYearSubDirectory(int month){
        int currYear = kalender.currYear;
        String path = dateSubPath + month +"_"+kalender.correspondingMonths[month];
        createSubDir(path,""+currYear);
    }

    public void initializeSubDirectories(){
        int counter = 0;
        for(String calenderMonth : kalender.correspondingMonths){
            int task = createSubDir(dateSubPath, counter+"_"+calenderMonth);
            if(task == -1){
                System.out.println("Es gab ein Problem bei: " + calenderMonth);
            }
            counter++;
        }
    }

    private int createSubDir(String pPath,String SubDirName) {
        File subDir = new File(pPath, SubDirName);
        if (subDir.mkdirs()) {
            return 0;
        } else {
            return -1;
        }
    }

    public int moveFile(File pFile, String directory){
        boolean fileMoved = pFile.renameTo(new File(directory, pFile.getName()));
        if(!fileMoved){
            return -1;
        }
        return 0;
    }

    public String getRelativPathForCurrentProcess(Termin pAppointment){
        Termin appointment = pAppointment;
        int month = appointment.getDate()[1];
        int year = appointment.getDate()[0];
        String path = month + "_" + kalender.correspondingMonths[month] + "/" + year + "/";
        return path;
    }

    private boolean checkIfPathExists(String path){
        return Files.exists(Paths.get(path));
    }


    public Path convertAppointmentToFile(Termin pAppointment){
        return null;
    }

    public Termin convertFileToAppointment(File pFile){
        return null;
    }
}
