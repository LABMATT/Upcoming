package space.labmatt.Interface;

import space.labmatt.Transport.Sessions;

public class Errors {


    public Errors(Sessions sessions) {
        // Errors function receives errors from around the program and prints them.

        if (!sessions.orgErrors.isEmpty()) {

            System.out.println("==Errors:==");

            for (String error : sessions.orgErrors) {

                System.out.println(error);
            }

            System.out.println("==END Errors: (" + sessions.orgErrors.size() +")==");

        } else {

            System.out.println("No Errors Found.");
        }
    }
}
