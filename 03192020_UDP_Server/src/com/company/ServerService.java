package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerService implements Runnable {

    private DatagramSocket datagramSocket;
    private DatagramPacket incomingPacket;

    public ServerService(DatagramSocket datagramSocket, DatagramPacket incomingPacket) {
        this.datagramSocket = datagramSocket;
        this.incomingPacket = incomingPacket;
    }

    @Override
    public void run() {
        try {
            String line = new String(incomingPacket.getData(), 0, incomingPacket.getLength());
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
