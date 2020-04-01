package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class BalancerListener extends Thread {

    private static final int DATAGRAM_SIZE = 1024;
    private static final String DELIMITER = ":";
    private int outerServerUdpPort;
    private HandlerInfo handler;

    public BalancerListener(int portNumber, HandlerInfo lastHandler) {
        this.outerServerUdpPort = portNumber;
        this.handler = lastHandler;
    }

    @Override
    public void run() {
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket(outerServerUdpPort);
        } catch (SocketException e) {
            e.printStackTrace();
            return;
        }
        byte[] incomingData = new byte[DATAGRAM_SIZE];
        DatagramPacket incomingPacket = new DatagramPacket(incomingData, DATAGRAM_SIZE);


        while (true) {
            try {
                serverSocket.receive(incomingPacket);
                String handlerInfoResult = new String(incomingPacket.getData(), 0, incomingPacket.getLength());
                updateHandler(handlerInfoResult);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void updateHandler(String handlerInfoResult) {
        String[] parts = handlerInfoResult.split(DELIMITER);
        String host = parts[0];
        int port = Integer.parseInt(parts[1]);
        handler.setHost(host);
        handler.setPort(port);
    }

}
