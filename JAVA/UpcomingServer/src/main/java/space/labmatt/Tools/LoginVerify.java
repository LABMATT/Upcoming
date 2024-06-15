package space.labmatt.Tools;

import org.java_websocket.WebSocket;
import space.labmatt.Transport.Struts.Command;

public class LoginVerify {


    public LoginVerify(WebSocket webSocket, Command command, ProjectPath path) {

        webSocket.send("{\"command\": \"verifyingLogin\"}");


    }
}
