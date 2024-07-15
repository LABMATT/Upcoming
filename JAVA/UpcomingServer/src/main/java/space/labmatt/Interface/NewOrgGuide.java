package space.labmatt.Interface;

import space.labmatt.Tools.NewOrganization;
import space.labmatt.Tools.ValidateString;
import space.labmatt.Transport.Struts.Organization;

import java.util.Scanner;

public class NewOrgGuide {

    public NewOrgGuide(String path) {
        // Guides a user though creating an origination.

        Scanner input = new Scanner(System.in);

        System.out.println("New Org > ");
        System.out.println("You will be guided though:");
        System.out.println("1. Naming the organization.");
        System.out.println("2. Adding contact emails.");
        System.out.println("3. Creating an admin account.");
        System.out.println("If at any point you would like to cancel. Just don't save at the end when prompted.");

        System.out.println("New Org > Enter Name: ");

        ValidateString validateString = new ValidateString();

        String orgName = null;
        String contacts = null;

        boolean validName = false;
        while (!validName) {
            orgName = input.nextLine();

            validName = validateString.isValidStandard(orgName);
        }

        System.out.println("New Org > Name Was (" + orgName + ").");
        System.out.println("New Org > Enter contacts EG (labmattcontact@gmail.com, otheremail@hotmail.com):");

        boolean validContacts = false;
        while (!validContacts) {
            contacts = input.nextLine();

            validContacts = validateString.isValidStandard(contacts);
        }

        System.out.println("New Org > Contacts: (" + contacts + ").");
        System.out.println("New Org > Attempting to create Organization.");

        NewOrganization newOrganization = new NewOrganization();
        newOrganization.addOrganization(path, orgName, contacts);

        System.out.println("== New organization complete. Returning to menu ==");
    }
}
