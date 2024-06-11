package space.labmatt.Tools;

import java.io.File;
import java.nio.file.Paths;

public class ProjectPath {

    static String path = null;

    public ProjectPath(String inpath) {

        boolean validPath = new File(inpath).isDirectory();

        if(inpath.isEmpty() || !validPath) {

            path = Paths.get("").toAbsolutePath().toString();
        } else {

            path = inpath;
        }
    }


    public String getPath() {

        return path;
    }
}
