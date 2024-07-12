package space.labmatt.Interface;

import space.labmatt.Tools.ValidateString;
import space.labmatt.Transport.Struts.Organization;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NewOrgGuide {

    public NewOrgGuide() {
        // Guides a user though creating an orgination.

        Scanner input = new Scanner(System.in);

        System.out.println("New Org > ");
        System.out.println("You will be guided though:");
        System.out.println("1. Naming the organization.");
        System.out.println("2. Adding contact emails.");
        System.out.println("3. Creating an admin account.");
        System.out.println("If at any point you would like to cancel. Just don't save at the end when prompted.");

        System.out.print("New Org > Enter Name: ");

        ValidateString validateString = new ValidateString();

        Organization organization = new Organization();
        organization.orgNAME = null;

        boolean validName = false;
        while (!validName) {
            organization.orgNAME = input.nextLine();

            validName = validateString.isValidStandard(organization.orgNAME);
        }


        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        organization.dateCREATED = localDateTime.format(dateTimeFormatter);



    }
}
