package space.labmatt.Transport;

import space.labmatt.Tools.ProjectPath;
import space.labmatt.Tools.newRandom;
import space.labmatt.Transport.Struts.Organization;

import java.io.File;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.List;

public class Sessions {

    List<Organization> organizationSessions;


    // Load the organizations from the file system into sessions.
    public void loadOrganizations(ProjectPath path) {

        File orgPath = new File(path.getPath());
        File events = new File(path.getPath());
        File logs = new File(path.getPath());
        File settings = new File(path.getPath());
        File users = new File(path.getPath());

        // Check if dirs of this org
        if (!orgPath.isDirectory()) {

            return;
        }

        if(!events.isDirectory()) {

            return;
        }

        if(!logs.isDirectory()) {

            return;
        }

        if(!settings.isDirectory()) {

            return;
        }

        if(!users.isDirectory()) {

            return;
        }


        // Now get the files in each folder that we require.
        File[] userlist = users.listFiles();
        File[] eventsList = events.listFiles();
        File orgSettings = File();

        for (File user : userlist) {


        }



    }


    // Using the hashmap we see if the orginastion exists. If it does then we return it. if not then null.
    public synchronized void getOrganisation(String organisationName) {


    }

}
