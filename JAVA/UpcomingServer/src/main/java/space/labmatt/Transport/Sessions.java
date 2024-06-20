package space.labmatt.Transport;

import com.google.gson.Gson;
import space.labmatt.Tools.ProjectPath;
import space.labmatt.Transport.Struts.Account;
import space.labmatt.Transport.Struts.Organization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class Sessions {

    List<Organization> organizationSessions;
    List<String> orgErrors;


    // Load the organizations from the file system into sessions.
    public void loadOrganizations(ProjectPath path) {

        String relPath = path.getPath() + File.separator + "upcomingServer" + File.separator + "organisation" + File.separator;


        File orgLocation = new File(relPath);

        // Check its DIR
        if(!orgLocation.isDirectory()) {

            System.out.println("Error, No Organization path.");
            return;
        }

        // List all the folders in the orgs folder.
        File[] orgs = orgLocation.listFiles();
        // If orgs folder is empty then do nothing.
        if(orgs == null) {

            System.out.println("No Organizations to load.");
            return;
        }


        // Loop though each org and load it into memory.
        for (File org : orgs) {

            loadFromFile(org.getPath());
        }


        System.out.println("Finished Loading Organizations.");
        System.out.println("Error Count: " + orgErrors.size());
    }


    // Gets passed a path and then trys loading its componets.
    // Then adds it to the List.
    private void loadFromFile(String path) {

        Organization organization = new Organization();

        File events = new File(path + File.separator + "events");
        File logs = new File(path + File.separator + "logs");
        File settings = new File(path + File.separator + "settings");
        File users = new File(path + File.separator + "users");

        // Check Organization file strutrue
        if(!events.isDirectory()) {

            orgErrors.add("Error getting " + path + " as events dir does not exist.");
            return;
        }

        if(!logs.isDirectory()) {

            orgErrors.add("Error getting " + path + " as logs dir does not exist.");
            return;
        }

        if(!settings.isDirectory()) {

            orgErrors.add("Error getting " + path + " as settings dir does not exist.");
            return;
        }

        if(!users.isDirectory()) {

            orgErrors.add("Error getting " + path + " as users dir does not exist.");
            return;
        }


        // Now get the files in each folder that we require.
        File[] userlist = users.listFiles();
        File[] eventsList = events.listFiles();
        File orgSettings = new File(settings.getPath() + File.separator + "settings.json");
        File orgMeta = new File(path + File.separator + "orgMeta.json");

        if(!orgSettings.isFile()) {

            orgErrors.add("Error getting " + path + " as the organizations settings does not exist.");
            return;
        } else {

            String orgSettingJson = readFile(orgSettings);
            // decript json

        }


        // Get each list and grab  the files. Decode them and then store in memory.
        if(userlist != null) {
            for (File user : userlist) {

                String usersFile = readFile(user);
                //usersFile = decript();
                Gson gson = new Gson();
                Account newAccount = gson.fromJson(usersFile, Account.class);
                organization.accountList.add(newAccount);

            }
        }

        if(eventsList != null) {
            for (File event : eventsList) {


            }
        }
    }


    // Feed a file in
    // Reads file
    // Returns string of file contents.
    private String readFile(File file) {

        String content = null;

        try {

            StringBuilder stringBuilder = new StringBuilder();
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            while (line!=null) {

                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }

            content = stringBuilder.toString();

        } catch (Exception e) {

            orgErrors.add("Error reading file: " + file.getName() + " Reason: " + e.getMessage());
        }


        return content;
    }


    // Using the hashmap we see if the orginastion exists. If it does then we return it. if not then null.
    public synchronized void getOrganisation(String organisationName) {


    }

}
