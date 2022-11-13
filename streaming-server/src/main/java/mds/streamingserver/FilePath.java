package mds.streamingserver;

import java.io.File;

public class FilePath {

    private final static String BASE_PATH = "C:\\Users\\jirka\\Documents\\GitHub\\BPC-MDS\\Videos\\";

    public final static File MP4_FILE = new File(BASE_PATH + "bbb_1080p.mp4");
    public final static String HLS_PATH = BASE_PATH + "HLS\\";
    public final static String DASH_PATH = BASE_PATH + "MPEG-DASH\\";

    public final static String MP4_DIRECTORY = BASE_PATH;
    public final static String IMAGES_DIRECTORY = BASE_PATH + "images\\";
    public final static String SUFFIX = "mp4";
}
