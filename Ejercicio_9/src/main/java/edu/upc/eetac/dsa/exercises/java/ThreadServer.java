package edu.upc.eetac.dsa.exercises.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by enric on 23/02/2016.
 */
public class ThreadServer implements Runnable {
    private static List<ThreadServer> threadList = Collections.synchronizedList(new ArrayList<ThreadServer>());

    private Socket socket = null;
    private String username = null;
    private BufferedReader reader = null;
    private PrintWriter writer = null;

    public ThreadServer(Socket socket) throws IOException {
        this.socket = socket;

        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            String[] msg = null;
            do {
                msg = reader.readLine().split(" ", 2);
                if (msg[0].equals("JOIN")) {
                    username = msg[1];
                    Thread.currentThread().setName(username + " thread");
                    threadList.add(this);
                    broadcast("estoy dentro.");
                } else if (msg[0].equals("MESSAGE")) {
                    broadcast(msg[1]);
                }
            } while (!msg[0].equals("LEAVE"));

            threadList.remove(this);
            broadcast("me piro.");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void broadcast(String msg) {
        for (ThreadServer t : threadList)
            t.send(username + "> " + msg);
    }

    private void send(String msg) {
        writer.println(msg);
        writer.flush();
    }
}