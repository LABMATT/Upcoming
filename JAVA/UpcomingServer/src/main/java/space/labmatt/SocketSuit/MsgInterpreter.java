package space.labmatt.SocketSuit;

import com.google.gson.Gson;
import org.java_websocket.WebSocket;
import space.labmatt.Tools.GetCommand;
import space.labmatt.Tools.LoginVerify;
import space.labmatt.Tools.ProjectPath;
import space.labmatt.Transport.Struts.Command;

public class MsgInterpreter {

    Gson gson = new Gson();

    // Makes sure that the input does not contain bad charters. If so then do nothing. else proceed.
    public MsgInterpreter(WebSocket webSocket, String message, ProjectPath path) {

        Command command = null;

        GetCommand getCommand = new GetCommand(message);

        try {
            command = gson.fromJson(message, Command.class);
        } catch (Exception e) {

            System.out.println(e);
        }

        // Make sure command is valid.
        if (command == null) {

            return;
        }

        switch (command.command) {
            case "login":
                System.out.println("LOGIN COMMANAD");

                new LoginVerify(webSocket, command, path);

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
                System.out.println("INVALID COMMAND < " + command.command + ">.");
                //new Error(webSocket, "Unexpected Command");
                break;
        }


    }
}
