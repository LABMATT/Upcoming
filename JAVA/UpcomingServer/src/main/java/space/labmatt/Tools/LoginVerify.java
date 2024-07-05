package space.labmatt.Tools;

import org.java_websocket.WebSocket;
import space.labmatt.Transport.Struts.Command;

public class LoginVerify {


    public LoginVerify(WebSocket webSocket, String message, ProjectPath path) {

        webSocket.send("{\"command\": \"verifyingLogin\"}");


    }
}
