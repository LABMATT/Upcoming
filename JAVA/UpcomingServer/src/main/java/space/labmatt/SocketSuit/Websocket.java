package space.labmatt.SocketSuit;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import space.labmatt.Tools.ProjectPath;

import java.net.InetSocketAddress;

// Runs the main websocket functions that will be called when connected and communcated.
public class Websocket extends WebSocketServer {

    ProjectPath path;

    // This sets the IP and the PORT
    public Websocket(InetSocketAddress addr, ProjectPath path) {

        super(addr);
        this.path = path;
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {

    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {

    }


    // When messages is recived send it to the interpater to work out what function to trigger.
    @Override
    public void onMessage(WebSocket webSocket, String message) {

        System.out.println("MESG: " + message);

        new MsgInterpreter(webSocket, message, path);
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {

    }

    @Override
    public void onStart() {

    }
}
