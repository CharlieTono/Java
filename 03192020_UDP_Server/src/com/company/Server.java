package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    static final int PORT = 3000;
    static final int INCOMING_DATAGRAM_SIZE = 1024;

    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        DatagramSocket datagramSocket = new DatagramSocket(PORT);

        while (true) {
            byte[] incomingData = new byte[INCOMING_DATAGRAM_SIZE];
            DatagramPacket incomingPacket = new DatagramPacket(incomingData, INCOMING_DATAGRAM_SIZE);
            datagramSocket.receive(incomingPacket);

            ServerService thSer = new ServerService(datagramSocket, incomingPacket);
            executorService.execute(thSer);
        }
    }
}
