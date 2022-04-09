package services.files.create;

import utils.DateFormatUtil;
import java.io.File;
import static constants.FilesMessages.DIR_CREATED;
import static constants.PathsMessages.CALCULATES_ROUTE_TO_ADD;

public class CreateDirService {
    private static final String PATH = CALCULATES_ROUTE_TO_ADD;
    public static String createDir() {
        String nameDir = new DateFormatUtil().getCurrentDate();
        File dir = new File("." + File.separator + PATH + nameDir);
        System.out.println(dir.getPath());
        // TODO: dir.mkdir creates one single directory at a time, but two directories are required here. Use dir.mkdirs instead
        boolean isDirCreated = dir.mkdirs();
        // TODO: What if dir could not be created? Probably, an exception would be good here
        if (isDirCreated) System.out.printf((DIR_CREATED) + "%n", nameDir);
        return dir.getPath();
    }
}
