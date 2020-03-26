package com.company;

import com.company.handler.HandlerPriorityQueue;

import java.io.IOException;
import java.net.*;

public class OuterSenderSender extends Thread {

    private static final int OUTER_SERVER_PORT = 2000;
    private static final String OUTER_HOST = "localhost";
    private static final int DATA_SIZE = 1024;
    private HandlerPriorityQueue servers;

    public OuterSenderSender(HandlerPriorityQueue servers) {
        this.servers = servers;
    }

    @Override
    public void run() {
        try {
            InetAddress address = InetAddress.getByName(OUTER_HOST);
            DatagramSocket socket = new DatagramSocket();

            byte[] dataOut = servers.getOptimal().toString().getBytes();

            while (true) {
                DatagramPacket packetOut = new DatagramPacket(dataOut, dataOut.length, address, OUTER_SERVER_PORT);
                socket.send(packetOut);
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

