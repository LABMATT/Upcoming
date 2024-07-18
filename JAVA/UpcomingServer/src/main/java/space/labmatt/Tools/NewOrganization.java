package space.labmatt.Tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import space.labmatt.Transport.Struts.Organization;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewOrganization {


    // Creates a new orginsation in the folder.
    // Convets name to lowercase and checks for iligle chars.
    // Gens the org a new ID.
    public void addOrganization(String path, String name, String contacts) {

        Organization org = new Organization();


        newRandom newRandom = new newRandom();
        String orgID = String.valueOf(newRandom.genrateRandom());
        String orgPath = path + File.separator + "upcomingServer" + File.separator + "organisation" + File.separator + orgID;
        File orgLoc = new File(orgPath);

        // Check the file name doesnt exist already. If so then gen another one.
        while (orgLoc.isDirectory()) {

            orgID = String.valueOf(newRandom.genrateRandom());
        }

        org.orgID = orgID;
        System.out.println("New Org > Org ID: " + orgID);


        // SanOrgName sanorgname = new sanorgname();
        // name = sanorgname.san(name);
        org.orgNAME = name;
        System.out.println("New Org > Org Name: " + name);


        // Create the current date
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        org.dateCREATED = localDateTime.format(dateTimeFormatter);
        System.out.println("New Org > Org Date Created: " + org.dateCREATED);


        // Contact details
        org.orgCONTACTS = contacts;
        System.out.println("New Org > Org Contacts: " + contacts);



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


        if(madeDIR) {
            // Write the orgmeta file to the org location.

            System.out.println("New Org > File structure created successfully.");

            try {

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonOutput = gson.toJson(org);

                FileWriter fileWriter = new FileWriter(orgPath + File.separator + "OrganisationMeta.json");
                fileWriter.write(jsonOutput);
                fileWriter.close();

                System.out.println("New Org > Organization Meta written sucessfuly.");

            } catch (IOException e) {

                System.out.println("New Org > Error writing org meta data. " + e.getMessage());
            }
        }
    }
}
