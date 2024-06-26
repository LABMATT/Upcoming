package space.labmatt.Tools;

import space.labmatt.Transport.Struts.Organization;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewOrganization {


    // Creates a new orginsation in the folder.
    // Convets name to lowercase and checks for iligle chars.
    // Gens the org a new ID.
    public void addOrganization(String name, ProjectPath path) {

        Organization org = new Organization();


        newRandom newRandom = new newRandom();
        String orgID = String.valueOf(newRandom.genrateRandom());
        String orgPath = path.getPath() + File.separator + "upcomingServer" + File.separator + "organisation" + File.separator + orgID;
        File orgLoc = new File(orgPath);

        // Check the file name doesnt exist already. If so then gen another one.
        while (orgLoc.isDirectory()) {

            orgID = String.valueOf(newRandom.genrateRandom());
        }

        org.orgID = orgID;


        // SanOrgName sanorgname = new sanorgname();
        // name = sanorgname.san(name);
        org.orgNAME = name;


        // Create the current date
        String patten = "yyyy/mm/dd";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(patten);
        org.dateCREATED = sdf.format(date);


        // Creates the folders and saves data.
        boolean madeDIR = orgLoc.mkdir();
        boolean subDIRs = true;

        File users = new File(orgPath + File.separator + "users");
        File events = new File(orgPath + File.separator + "events");
        File logs = new File(orgPath + File.separator + "logs");
        File settings = new File(orgPath + File.separator + "settings");


        // make the sub DIRS in the orgnisations folder. If somthing fails then throw a flag.
        if(madeDIR) {

            if(!users.mkdir())
            {
                subDIRs = false;
            }

            if(events.mkdir()) {
                subDIRs = false;
            }

            if(logs.mkdir()) {
                subDIRs = false;
            }

            if(settings.mkdir()) {
                subDIRs = false;
            }
        }

    }
}
