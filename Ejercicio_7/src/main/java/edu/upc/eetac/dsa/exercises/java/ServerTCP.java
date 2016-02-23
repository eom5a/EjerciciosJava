package edu.upc.eetac.dsa.exercises.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

/**
 * Created by enric on 23/02/2016.
 */
public class ServerTCP {

    private final static int PUERTO = 12345;

    public static void main(String[] args) throws IOException {
        /**
         * Ternario: El puerto seria igual si los args.length == 1 se ejecuta la sentencia 1
         * (Integer.parseInt(args[0]). Si no es así se utilizara la secuencia2 (PUERTO)
         */
        int port = (args.length == 1) ? Integer.parseInt(args[0]) : PUERTO;


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        /**
         Creamos un bucle, para que escuche todas las peticiones con serverSocket.accept()
         Creamos un Printwriter que escribira en socket.getOutputStream()
         Con el println imprimimos en el mismo socket mediante el writer.
         Despues hacemos un flush para hacer una especie de (No Delay).
         */
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println(sdf.format(System.currentTimeMillis()));
            writer.flush();
        }
    }
}
