package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

public class UDP_Balancer_Connection {

    private static final int INCOMING_DATAGRAM_SIZE = 1024;
    private int portNumber;
    private InetAddress inetAddress;
    private Deque<String> result = new ArrayDeque<>();

    public UDP_Balancer_Connection(int portNumber, InetAddress inetAddress) {
        this.portNumber = portNumber;
        this.inetAddress = inetAddress;
    }

    public Deque<String> getResult() {
        return result;
    }

    public String requestForFreeHandlerFromBalancer() throws IOException {

        DatagramSocket socketForBalancer = new DatagramSocket();
        byte[] incomingData = new byte[INCOMING_DATAGRAM_SIZE];
        DatagramPacket incomingPacket = new DatagramPacket(incomingData, INCOMING_DATAGRAM_SIZE);

        String line = "request";
        byte[] outGoingData = line.getBytes();
        DatagramPacket outgoingPacket = new DatagramPacket(outGoingData, outGoingData.length, inetAddress, portNumber);
        socketForBalancer.send(outgoingPacket);

        socketForBalancer.receive(incomingPacket);

        String handlerInfoResult = new String(incomingPacket.getData(), 0, incomingPacket.getLength());
        System.out.println(handlerInfoResult);

        socketForBalancer.close();
        return handlerInfoResult;
    }
}
