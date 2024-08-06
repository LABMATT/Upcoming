package space.labmatt.Interface;

import space.labmatt.Transport.Sessions;
import space.labmatt.Transport.Struts.Organization;

import java.util.List;
import java.util.Scanner;

public class EditOrg {

    public EditOrg(Sessions sessions) {
        // Asks you to select a current orgination with ID then if valid sends you to an editor.

        Scanner input = new Scanner(System.in);
        List<Organization> organizationSessions = sessions.getOrganizationSessions();

        boolean editOrgRunning = true;
        while (editOrgRunning) {

            System.out.println(" ");
            System.out.println("Edit Org > Enter Organization ID number from list.");

            new ListOrgs(sessions);

            System.out.println("Edit Org > Enter Organization ID number from list.");
            System.out.println("Edit Org > Or type EXIT to exit.");

            String inputline = input.nextLine();

            if(inputline.equals("exit")) {

                editOrgRunning = false;
                break;
            }

            Organization workingOrg = null;

            for(Organization org : organizationSessions) {

                if (org.orgID.equals(inputline)) {

                    workingOrg = org;

                    System.out.println("Found Origination (" + workingOrg.orgNAME + ").");

                    break;
                }
            }

            if(workingOrg == null) {

                System.out.println("No Origination by ID (" + inputline + ") found.");
            }

        }

        System.out.println("=== END OF EDITING MENU ===");
    }
}
