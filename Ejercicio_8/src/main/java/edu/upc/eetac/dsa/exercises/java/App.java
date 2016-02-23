package edu.upc.eetac.dsa.exercises.java;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        if (args.length < 2) {
            System.err.println("You have to pass the server name and the server port");
            System.exit(-1);
        }
        /**
         * Sacamos los valores del args[]
         */
        String server = args[0];
        int port = Integer.parseInt(args[1]);

        /**
         * Para activar la conexión UDP enviamos un Datagrama vacio para que el servidor nos responda.
         * Al ser UDP no hay control de session, ni stream, ...
         *
         * Para crear un datagrama se necessita: la info, la longitud de la info, y destino + puerto.
         */
        byte[] data = new byte[0];
        DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getByName(server), port);
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(dp);

        /**
         * Despues creamos un Array para almacenar la respuesta del servidor.
         *
         * Con datagramSocket.receive("objeto donde almacenamos"); recibimos el datagrama.
         *
         * Despues lo descodificamos con .readUTF();
         *
         * byte[] array --> DatagramPacket --> ByteArrayInputStream --> DataInputStream --> UTF
         */

        byte[] buffer = new byte[1496];
        dp = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(dp);
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(dp.getData()));
        String time = dis.readUTF();
        System.out.println(time);
    }
    }
}
