package space.labmatt;

import org.java_websocket.server.DefaultSSLWebSocketServerFactory;
import org.java_websocket.server.WebSocketServer;

import javax.net.ssl.SSLContext;
import java.net.InetSocketAddress;

import space.labmatt.Encrypt.Cyrpt;
import space.labmatt.Encrypt.GenSSL;
import space.labmatt.Interface.CommandLine;
import space.labmatt.SocketSuit.Websocket;
import space.labmatt.Tools.*;
import space.labmatt.Transport.Sessions;
import space.labmatt.Transport.Struts.Command;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

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
        NewOrganization norg = new NewOrganization();
        //Cyrpt crypt = new Cyrpt(path);

        norg.addOrganization("TestOr", path);

        // Load organizations into memory
        System.out.println("Loading Organizations into memory.");
        Sessions sessions = new Sessions();
        sessions.loadOrganizations(path);


        // Create the folder setup.
        new GenFileStrut(path.getPath());

        // Create Socket
        //SocketAuth socketAuth = new SocketAuth(ip, socketPort);

        // Create a commandline interprater instance.
        CommandLine commandLine = new CommandLine(path, sessions);
        Thread thread = new Thread(commandLine);
        thread.start();

        // Creates a new websocket server.
        WebSocketServer webSocketServer = new Websocket(new InetSocketAddress(ip, webSocketPort), path);
        //webSocketServer.setWebSocketFactory(new DefaultSSLWebSocketServerFactory(sslKey));
        webSocketServer.run();


    }
}