package com.company.handler;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlerListener extends Thread {

    private static final int BALANCER_UPD_PORT = 3700;
    private static final int DATAGRAM_SIZE = 1024;
    private static final int THREADS_NUMBER = 10;

    private HandlerPriorityQueue servers;

    public HandlerListener(HandlerPriorityQueue servers) {
        this.servers = servers;
    }

    @Override
    public void run() {

        try {
            DatagramSocket serverSocket = new DatagramSocket(BALANCER_UPD_PORT);
            ExecutorService executorService = Executors.newFixedThreadPool(THREADS_NUMBER);

            while (true) {
                byte[] dataFromHandler = new byte[DATAGRAM_SIZE];
                DatagramPacket packetFromHandler = new DatagramPacket(dataFromHandler, DATAGRAM_SIZE);
                serverSocket.receive(packetFromHandler);
                executorService.execute(new HandlerDataReceiver(packetFromHandler, servers));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
