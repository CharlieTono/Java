package com.company;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCP_Client_Connection {

    private int outerServerPortNumber;
    private int balancerPortNumber;
    private int handlerFirstPortNumber;
    private int handlerSecondPortNumber;
    private int handlerThirdPortNumber;

    public TCP_Client_Connection(int outerServerPortNumber, int balancerPortNumber, int handlerFirstPortNumber, int handlerSecondPortNumber, int handlerThirdPortNumber) {
        this.outerServerPortNumber = outerServerPortNumber;
        this.balancerPortNumber = balancerPortNumber;
        this.handlerFirstPortNumber = handlerFirstPortNumber;
        this.handlerSecondPortNumber = handlerSecondPortNumber;
        this.handlerThirdPortNumber = handlerThirdPortNumber;
    }

    public void receiveTaskFromClient() throws IOException {
        ServerSocket mainSocket = new ServerSocket(outerServerPortNumber);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        InetAddress serverIp = InetAddress.getByName("localhost");

        while (true) {
            System.out.println("test");
            Socket socketForClient = mainSocket.accept();
            ThreadOuterServerService threadOuterServer = new ThreadOuterServerService(socketForClient, serverIp, balancerPortNumber, handlerFirstPortNumber, handlerSecondPortNumber, handlerThirdPortNumber);
            executor.execute(threadOuterServer);
        }
    }
}
