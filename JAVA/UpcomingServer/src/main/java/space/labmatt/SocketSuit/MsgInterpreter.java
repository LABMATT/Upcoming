package space.labmatt.SocketSuit;

import org.java_websocket.WebSocket;
import space.labmatt.Tools.GetCommand;
import space.labmatt.Tools.LoginVerify;
import space.labmatt.Tools.ProjectPath;


public class MsgInterpreter {

    public MsgInterpreter(WebSocket webSocket, String message, ProjectPath path) {
        /*
        Message Interrupter:
        - Receive input as string.
        - Split string into command and message
        - Based on command send the message to the correct function.
         */

        GetCommand getCommand = new GetCommand(message);

        System.out.println("Resultint: " + getCommand.command + " Message: " + getCommand.message);

        if (getCommand.command.isEmpty() || getCommand.message.isEmpty()) {

            return;
        }

        if (!getCommand.errors.isEmpty()) {

            for (String error : getCommand.errors) {

                System.out.println("Command Error: " + error);
            }
            return;
        }




        switch (getCommand.command) {
            case "login":
                System.out.println("LOGIN COMMANAD");

                new LoginVerify(webSocket, getCommand.message, path);

                break;
            case "requestLOGS":
                System.out.println("request logs");
                //RequestEntry requestEntry = new RequestEntry();
                //requestEntry.getEntrys(webSocket, path);
                break;

            case "archive":
                //new Archive(webSocket, path, command.message);
                //new RequestEntry().reloadEntrys(path);
                webSocket.send("{\"command\": \"reload\"}");
                break;

            case "approve":
                //new Approve(webSocket, path, command.message);
                //new RequestEntry().reloadEntrys(path);
                webSocket.send("{\"command\": \"reload\"}");
                break;

            case "newEntry":
                System.out.println("New entery");
                //new NewEntery(webSocket, path, command.entry);
                break;
            case "reload":
                //new RequestEntry().reloadEntrys(path);
                break;

            default:
                System.out.println("INVALID COMMAND < " + getCommand.command + ">.");
                //new Error(webSocket, "Unexpected Command");
                break;
        }
    }
}
