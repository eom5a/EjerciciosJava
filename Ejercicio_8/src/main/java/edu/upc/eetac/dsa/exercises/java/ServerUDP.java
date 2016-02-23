package edu.upc.eetac.dsa.exercises.java;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;

/**
 * Created by enric on 23/02/2016.
 */
public class ServerUDP {
    private final static int DEFAULT_PORT = 12345;

    public static void main(String[] args) throws IOException {
        int port = (args.length == 1) ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        DatagramSocket datagramSocket = new DatagramSocket(port);

        /**
         * Igual que el TCP hacemos un bucle para responder las peticiones.
         *
         * Creamos un Datagrama vacio y con datagramSocket esperamos la llegada con datagramSocket.receive
         */


        while (true) {
            byte[] buffer = new byte[0];
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(datagramPacket);

            /**
             * datagramPacket contiene la informacion de dirrecion y puerto.
             *
             * UTF --> DataOutputStream --> ByteArrayOutput --> DatagramPacket --> Envio
             */
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeUTF(sdf.format(System.currentTimeMillis()));
            byte[] data = baos.toByteArray();

            DatagramPacket datagramPacketenvio = new DatagramPacket(data, data.length, datagramPacket.getAddress(), datagramPacket.getPort());
            datagramSocket.send(datagramPacketenvio);
        }
    }
}
