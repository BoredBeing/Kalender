package Calendar_logic;

import Calendar_utils.Appointment;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileManager{

    Calendar calendar;
    String path;
    String bufferSubPath;
    String bookmarkSubPath;
    String dateSubPath;
    Appointment[] currProcesses = new Appointment[10];
    int processingIndex = 0;
    Appointment currProcess = null;

    public static void main(String[] args){
        Calendar k = new Calendar();
        FileManager fm = k.fm;
        k.createAppointment(2025, 7, 0, "test");
        String path = fm.getRelativPathForCurrentProcess(k.tempStorage[0]);
        System.out.println(fm.checkIfPathExists(fm.dateSubPath + path));
    }

    public FileManager(Calendar pKalender) {
        System.out.println("Calendar_Application.FileManager started:");
        calendar = pKalender;
        path = pKalender.absPath;
        bufferSubPath = path + calendar.BufferSubPath;
        bookmarkSubPath = path + calendar.BookmarkSubPath;
        dateSubPath = path + calendar.dateSubPath;

    }

    public int addProcess(Appointment pAppointment) {
        if(currProcesses[processingIndex] == null) {
            currProcesses[processingIndex] = pAppointment;
            return processingIndex;
        }
        int i = 0;
        do {
            i++;
            if (((currProcesses.length - 1) >= processingIndex + i )&&(currProcesses[processingIndex+i] == null)) {
                currProcesses[processingIndex + i] = pAppointment;
                return (processingIndex + i);
            }
        }while(i!=currProcesses.length-1);
        return(-1);
    }

    public void initializeYearSubDirectory(int month){
        int currYear = calendar.currYear;
        String path = dateSubPath + month +"_"+ calendar.correspondingMonths[month];
        createSubDir(path,""+currYear);
    }

    public void initializeSubDirectories(){
        int counter = 0;
        for(String calenderMonth : calendar.correspondingMonths){
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

    public String getRelativPathForCurrentProcess(Appointment pAppointment){
        Appointment appointment = pAppointment;
        int month = appointment.getDate()[1];
        int year = appointment.getDate()[0];
        String path = month + "_" + calendar.correspondingMonths[month] + "/" + year + "/";
        return path;
    }

    private boolean checkIfPathExists(String path){
        return Files.exists(Paths.get(path));
    }


    public Path convertAppointmentToFile(Appointment pAppointment){
        return null;
    }

    public Appointment convertFileToAppointment(File pFile){
        return null;
    }
}
