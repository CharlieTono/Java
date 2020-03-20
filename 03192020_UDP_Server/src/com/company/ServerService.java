package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerService implements Runnable {

    static final int INCOMING_DATAGRAM_SIZE = 1024;
    private DatagramSocket datagramSocket;

    public ServerService(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {

        while (true) {
            byte[] incomingData = new byte[INCOMING_DATAGRAM_SIZE];
            DatagramPacket incomingPacket = new DatagramPacket(incomingData, INCOMING_DATAGRAM_SIZE);
            try {
                datagramSocket.receive(incomingPacket);

                String line = new String(incomingData, 0, incomingPacket.getLength());
                line = "Hello from UDP server: " + line;

                DatagramPacket outgoingPacket = new DatagramPacket(
                        line.getBytes(),
                        line.length(),
                        incomingPacket.getAddress(),
                        incomingPacket.getPort());
                datagramSocket.send(outgoingPacket);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
