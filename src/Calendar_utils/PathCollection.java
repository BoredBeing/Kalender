package Calendar_utils;

public class PathCollection {
    private String PROJECTPATH = "home/Tobi/Boring_Projects/java/Calendar/";
    private String DATAPATH = "home/Tobi/Boring_Projects/java/Calendar/Data/";
    private String DATASUBPATH = "/Data/";

    private String WEBSTUFF = "Calendar_userinterface/web/";


    public PathCollection(){};

    public String getProjectPath(){
        return PROJECTPATH;
    }

    public String getDataPath(){
        return DATAPATH;
    }

    public String getDataSubPath(){
        return DATASUBPATH;
    }
}
