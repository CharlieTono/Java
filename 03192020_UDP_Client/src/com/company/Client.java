package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {

    static final int INCOMING_DATAGRAM_SIZE = 1024;
    static final int SERVER_PORT = 3000;

    public static void main(String[] args) throws IOException {

        InetAddress serverIp = InetAddress.getByName("localhost");
        DatagramSocket socket = new DatagramSocket();

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = consoleReader.readLine()) != null && !line.equals("exit")) {
            byte[] outGoingData = line.getBytes();
            DatagramPacket outgoingPacket = new DatagramPacket(outGoingData, outGoingData.length, serverIp, SERVER_PORT);
            socket.send(outgoingPacket);

            byte[] incomingData = new byte[INCOMING_DATAGRAM_SIZE];
            DatagramPacket incomingPacket = new DatagramPacket(incomingData, INCOMING_DATAGRAM_SIZE);
            socket.receive(incomingPacket);

            String result = new String(incomingPacket.getData(), 0, incomingPacket.getLength());
            System.out.println(result);
        }
        socket.close();
    }
}

