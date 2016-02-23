package edu.upc.eetac.dsa.exercises.java;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by enric on 23/02/2016.
 */
public class ServerChat implements Runnable {
    private int port;
    private Thread thread;

    public final static int DEFAULT_PORT = 3333;

    public ServerChat(int port) {
        this.port = port;
    }

    public void startServer() {
        if (thread == null)
            (thread = new Thread(this, "Server main thread")).start();
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Chat server up, listening at " + port);
            while (true) {
                Socket socket = ss.accept();
                (new Thread(new ThreadServer(socket))).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = (args.length == 1) ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        ServerChat server = new ServerChat(port);
        server.startServer();
    }
}