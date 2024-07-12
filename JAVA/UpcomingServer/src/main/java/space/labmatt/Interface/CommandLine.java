package space.labmatt.Interface;

import space.labmatt.Tools.ProjectPath;
import space.labmatt.Transport.Sessions;

import java.util.Scanner;

public class CommandLine implements Runnable{

    Sessions sessions = null;
    String path = "";

    public CommandLine(ProjectPath path, Sessions sessions) {
        // Sets the things we might use later such as the path and sessions.

        this.path = path.getPath();
        this.sessions = sessions;
    }


    @Override
    public void run() {
        // The command line takes an input then sends us to the right function for execution.

        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {

        }

        boolean running = true;
        Scanner input = new Scanner(System.in);

        while (running) {
            System.out.print("Main Menu > ");

            String inputline = input.nextLine();

            switch (inputline) {
                case "list":
                    new ListOrgs(sessions);
                    break;
                case "exit":
                    running = false;
                    break;
                case "help":
                    new Help();
                    break;
                case "errors":
                    new Errors(this.sessions);
                    break;
                case "new":
                    new NewOrgGuide();
                    break;
                default:
                    System.out.println("Unknown Command.");
                    break;
            }
        }
    }
}
