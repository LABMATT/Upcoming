package space.labmatt.SocketSuit;

import labmatt.space.Auth.CheckAuth;
import labmatt.space.Loging.LogEntery;
import labmatt.space.Loging.ProjectPath;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class Websocket extends WebSocketServer {

    ProjectPath path;

    // This sets the IP and the PORT
    public Websocket(InetSocketAddress addr, ProjectPath path) {

        super(addr);
        this.path = path;
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {

        new LogEntery(webSocket, clientHandshake);

        new CheckAuth();
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {

    }

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
