package space.labmatt.Tools;

import java.io.File;

// Checks if the file structure exists already. If not creates it.
public class GenFileStrut {

    public GenFileStrut(String workingDIR) {

        System.out.println("Checking File Structure...");

        boolean nothingFlagged = false;
        GenEntryID genEntryID = new GenEntryID();

        // Get the path of the jar.
        System.out.println("Current Working DIR: " + workingDIR);

        File mainFolder = new File(workingDIR + File.separator + "upcomingServer" + File.separator);
        File org = new File(workingDIR + File.separator + "upcomingServer" + File.separator + "organisation");
        File settings = new File(workingDIR + File.separator + "upcomingServer" + File.separator + "settings");
        File logs = new File(workingDIR + File.separator + "upcomingServer" + File.separator + "logs");


        // Check if main folder exits if not then create them.
        if(!mainFolder.isDirectory()) {

            System.out.println("Creating Folder: " + mainFolder.getPath());
            boolean flagDir = mainFolder.mkdir();

            System.out.println("Content Result: " + flagDir);
            nothingFlagged = true;
        }


        // Check if main folder exits if not then create them.
        if(!org.isDirectory()) {

            System.out.println("Creating Folder: " + org.getPath());
            boolean flagDir = org.mkdir();

            System.out.println("Content Result: " + flagDir);
            nothingFlagged = true;
        }


        // Check if main folder exits if not then create them.
        if(!settings.isDirectory()) {

            System.out.println("Creating Folder: " + settings.getPath());
            boolean flagDir = settings.mkdir();

            System.out.println("Content Result: " + flagDir);
            nothingFlagged = true;
        }


        // Check if main folder exits if not then create them.
        if(!logs.isDirectory()) {

            System.out.println("Creating Folder: " + logs.getPath());
            boolean flagDir = logs.mkdir();

            System.out.println("Content Result: " + flagDir);
            nothingFlagged = true;
        }

        System.out.println("FILE SYSTEM CHECK COMPLETE.");

        if(!nothingFlagged)
        {
            System.out.println("RESULT: OK");
        } else {
            System.out.println("RESULT: FOLDERS CREATED SEE ABOVE");
            System.exit(0);
        }
    }
}
