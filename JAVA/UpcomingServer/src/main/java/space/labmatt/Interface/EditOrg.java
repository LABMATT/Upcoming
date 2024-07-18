package space.labmatt.Interface;

import space.labmatt.Transport.Sessions;

import java.util.Scanner;

public class EditOrg {

    public EditOrg(Sessions sessions) {

        Scanner input = new Scanner(System.in);

        boolean editOrgRunning = true;
        while (editOrgRunning) {

            listOrganizations();

            System.out.println("Edit Org > Enter Organization ID number from list.");

            new ListOrgs(sessions);

            System.out.println("Edit Org > Enter Organization ID number from list.");
            System.out.println("Edit Org > Or type EXIT to exit.");

            String inputline = input.nextLine();

            switch (inputline) {
                case "exit":
                    editOrgRunning = false;
                    break;
            }
        }

        System.out.println("=== END OF EDITING MENU ===");
    }


    private void listOrganizations() {



    }
}
