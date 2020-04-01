package com.company;

import com.company.handler.HandlerPriorityQueue;
import com.company.handler.HandlerServer;

import java.io.IOException;
import java.net.*;

public class OuterSenderSender implements Runnable {

    private static final int OUTER_SERVER_PORT = 3800;
    private static final String OUTER_HOST = "localhost";
    private HandlerPriorityQueue servers;

    public OuterSenderSender(HandlerPriorityQueue servers) {
        this.servers = servers;
    }

    @Override
    public void run() {
        try {
            InetAddress address = InetAddress.getByName(OUTER_HOST);
            DatagramSocket socket = new DatagramSocket();

            HandlerServer handlerServer = servers.getOptimal();

            if (handlerServer == null) {
                return;
            }

            byte[] dataOut = servers.getOptimal().toString().getBytes();

            DatagramPacket packetOut = new DatagramPacket(dataOut, dataOut.length, address, OUTER_SERVER_PORT);
            socket.send(packetOut);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

