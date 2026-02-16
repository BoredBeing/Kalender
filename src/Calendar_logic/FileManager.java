package Calendar_logic;


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
    int processingIndex = 0;



    public FileManager(Calendar pKalender) {
        System.out.println("Calendar_Application.FileManager started:");
        calendar = pKalender;
        path = pKalender.absPath;
        bufferSubPath = path + calendar.BufferSubPath;
        bookmarkSubPath = path + calendar.BookmarkSubPath;
        dateSubPath = path + calendar.dateSubPath;

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



    private boolean checkIfPathExists(String path){
        return Files.exists(Paths.get(path));
    }



}
