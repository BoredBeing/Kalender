package Calendar_logic;

import Calendar_utils.PathCollection;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager{
    public PathCollection pathCollection = new PathCollection();
    public String dataPath = "";
    public File dataHomePath = new File("Data/");

    Calendar calendar = null;

    public static void main(String[] args) {
        FileManager fm = new FileManager();
        fm.printFileNames(fm.loadDataFrom(2026,"December"));
    }

    public FileManager(){

    }


    public File[] loadDataFrom(int pYear, String pMonth) {
        File test = getFileFromYearAndMonth(pYear,pMonth);
        System.out.println(test.getAbsolutePath());
        return test.listFiles();
    }

    public void printFileNames(File[] testArray) {
        for (int i = 0;i<= testArray.length-1;i++){
            System.out.println(testArray[i]);
        }
    }

    public File getFileFromYear(int pYear){
        String path = "Data/Data_" + pYear + "/";
        File test = new File(path);
        return test;
    }

    public File getFileFromYearAndMonth(int pYear, String pMonth){
        String path = "Data/Data_"+ pYear + "/" + pMonth + "/";
        File test = new File(path);
        return test;
    }

    public File initializeYearSubDirectory(int pYear){
        return createSubDir(dataHomePath.getName() + "/","Data_" + pYear);
    }

    public File initializeMonthSubDirectory(int pYear, String pMonth) {
        File year = getFileFromYear(pYear);
        if(!year.exists()) {
            year = initializeYearSubDirectory(pYear);
        }
        return createSubDir(year.getPath(),pMonth);

    }

    private File createSubDir(String pPath,String SubDirName) {
        File subDir = new File(pPath, SubDirName);
        if (subDir.mkdirs()) {
            return subDir;
        } else {
            System.out.println("subDirectory failed to create");
            return null;
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
