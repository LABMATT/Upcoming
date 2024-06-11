package space.labmatt;

import org.java_websocket.server.DefaultSSLWebSocketServerFactory;
import org.java_websocket.server.WebSocketServer;

import javax.net.ssl.SSLContext;
import java.net.InetSocketAddress;
import space.labmatt.Encrypt.GenSSL;
import space.labmatt.SocketSuit.Websocket;
import space.labmatt.Tools.GenFileStrut;
import space.labmatt.Tools.InitializeSessions;
import space.labmatt.Tools.ProjectPath;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        InitializeSessions initializeSessions = new InitializeSessions();

        GenSSL genSSL = new GenSSL();

        String ip = "192.168.1.102";
        String socketPort = "433";
        int webSocketPort = 433;
        SSLContext sslKey = null;
        try {
            sslKey = genSSL.getKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ProjectPath path = new ProjectPath("");

        // Create the folder setup.
        new GenFileStrut(path.getPath());

        // Create Socket
        //SocketAuth socketAuth = new SocketAuth(ip, socketPort);

        // Creates a new websocket server.
        WebSocketServer webSocketServer = new Websocket(new InetSocketAddress(ip, webSocketPort), path);
        webSocketServer.setWebSocketFactory(new DefaultSSLWebSocketServerFactory(sslKey));
        webSocketServer.run();
    }
}