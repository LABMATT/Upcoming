package space.labmatt.Tools;


import labmatt.space.Entry.GenEntryID;

import java.io.File;

// Checks if the file structure exists already. If not creates it.
public class GenFileStrut {

    public GenFileStrut(String workingDIR) {

        System.out.println("Checking File Structure...");

        boolean nothingFlagged = false;
        GenEntryID genEntryID = new GenEntryID();

        // Get the path of the jar.
        System.out.println("Current Working DIR: " + workingDIR);

        File content = new File(workingDIR + "/content/");
        File contentYear = new File(workingDIR + "/content/" + genEntryID.folderDate() + "/");
        File settings = new File(workingDIR + "/settings/");
        File logs = new File(workingDIR + "/logs/");
        File profiles = new File(workingDIR + "/profiles/");


        // Check if exist if not then create them.
        if(!content.isDirectory()) {

            System.out.println("Creating Folder: " + workingDIR + "/content/");
            boolean flagDir = content.mkdir();

            System.out.println("Content Result: " + flagDir);
            nothingFlagged = true;
        }

        // Check if exist if not then create them.
        if(!contentYear.isDirectory()) {

            System.out.println("Creating Folder: " + workingDIR + "/content/" + genEntryID.folderDate() + "/");
            boolean flagDir = contentYear.mkdir();

            System.out.println("ContentYear Result: " + flagDir);
            nothingFlagged = true;
        }

        if(!settings.isDirectory()) {

            System.out.println("Creating Folder: " + workingDIR + "/settings/");
            boolean flagDir = settings.mkdir();

            System.out.println("Settings Result: " + flagDir);
            nothingFlagged = true;
        }

        if(!logs.isDirectory()) {

            System.out.println("Creating Folder: " + workingDIR + "/logs/");
            boolean flagDir = logs.mkdir();

            System.out.println("Logs Result: " + flagDir);
            nothingFlagged = true;

        }

        if(!profiles.isDirectory()) {

            System.out.println("Creating Folder: " + workingDIR + "/profiles/");
            boolean flagDir = profiles.mkdir();

            System.out.println("Profiles Result: " + flagDir);
            nothingFlagged = true;

        }

        System.out.println("FILE SYSTEM CHECK COMPLETE.");

        if(!nothingFlagged)
        {
            System.out.println("RESULT: OK");
        } else {
            System.out.println("RESULT: SEE ABOVE");
        }
    }
}
