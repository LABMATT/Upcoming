package space.labmatt.Interface;

import space.labmatt.Transport.Sessions;
import space.labmatt.Transport.Struts.Organization;

import java.util.List;

public class ListOrgs {

    public ListOrgs(Sessions sessions) {
        // List each org and its name + status.

        System.out.println("==List Orgs==");

        List<Organization> organizationSessions = sessions.getOrganizationSessions();

        if(organizationSessions == null || organizationSessions.isEmpty()) {

            System.out.println("No organizations to show.");
            System.out.println("== END ==");
            return;
        }

        for (Organization organization : organizationSessions) {

            int users = 0;
            if(organization.accountList != null && !organization.accountList.isEmpty()) {

                users = organization.accountList.size();
            }

            System.out.println("ORG: Name:" + organization.orgNAME + " ID:" + organization.orgID + " Created:" + organization.dateCREATED + " Users:" + users);
        }


        System.out.println("=== END LIST: (" + organizationSessions.size() + ") === ");
    }
}
