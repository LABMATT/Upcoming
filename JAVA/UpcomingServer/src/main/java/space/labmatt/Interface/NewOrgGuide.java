package space.labmatt.Interface;

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

        String orgname = null;

        boolean validName = false;
        while (!validName) {
            orgname = input.nextLine();

        }



    }
}
