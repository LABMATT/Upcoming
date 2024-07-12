package space.labmatt.Interface;

import space.labmatt.Transport.Sessions;
import space.labmatt.Transport.Struts.Organization;

public class ListOrgs {

    public ListOrgs(Sessions sessions) {
        // List each org and its name + status.

        System.out.println("==List Orgs==");

        if(sessions.organizationSessions == null || sessions.organizationSessions.isEmpty()) {

            System.out.println("No organizations to show.");
            System.out.println("== END ==");
            return;
        }

        for (Organization organization : sessions.organizationSessions) {

            System.out.println("ORG: Name:" + organization.orgNAME + " ID:" + organization.orgID + " Created:" + organization.dateCREATED + " Users:" + organization.accountList.size());
        }


        System.out.println("==END LIST: (" + sessions.organizationSessions.size() + ") ==");
    }
}
