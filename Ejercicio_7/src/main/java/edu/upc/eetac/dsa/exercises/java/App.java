package edu.upc.eetac.dsa.exercises.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class App {
    public static void main(String[] args) throws IOException {
        /**
         Si al passar los argumentos hay menos de dos, significa que falta o el IP del servidor o el puerto
         */
        if (args.length < 2) {
            System.err.println("You have to pass the server name and the server port");
            System.exit(-1);
        }

        String server = args[0];
        int port = Integer.parseInt(args[1]);

        /**
         Abrimos un socket con la Ip del servidor y el puerto del servidor
         */
        Socket socket = new Socket(server, port);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String time = reader.readLine();
        System.out.println(time);
    }
}
