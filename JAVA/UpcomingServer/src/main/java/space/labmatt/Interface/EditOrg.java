package space.labmatt.Interface;

import java.util.Scanner;

public class EditOrg {

    public EditOrg() {

        Scanner input = new Scanner(System.in);

        boolean editOrgRunning = true;
        while (editOrgRunning) {

            listOrganizations();

            System.out.println("Edit Org > Enter Organization number from list.");
            String inputline = input.nextLine();

            switch (inputline) {

            }
        }
    }


    private void listOrganizations() {



    }
}
