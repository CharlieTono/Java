package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCP_Handler_Connection {

    private int firstPort;
    private int secondPort;
    private int thirdPort;
    private String handlerInfoResult;
    private String message;

    public TCP_Handler_Connection(int firstPort, int secondPort, int thirdPort, String handlerInfoResult, String message) {
        this.firstPort = firstPort;
        this.secondPort = secondPort;
        this.thirdPort = thirdPort;
        this.handlerInfoResult = handlerInfoResult;
        this.message = message;
    }

    public String sendTaskToFreeHandler() throws IOException {

        if (handlerInfoResult == null) {// if balancer doesn`t answer //TODO put correct boolean expression
        }

        String[] loadInfo = handlerInfoResult.split("#"); //""load#TCPPort#IP""
        int freeHandlerPortNumber = Integer.parseInt(loadInfo[1]);
        String ipAddress = loadInfo[2];

        Socket socketForHandler = new Socket(ipAddress, freeHandlerPortNumber);

        PrintWriter socketOutPut = new PrintWriter(message);
        socketOutPut.flush();
        BufferedReader socketInput = new BufferedReader(new InputStreamReader(socketForHandler.getInputStream()));

        System.out.println("Answer from the handler " + socketInput.readLine());

        socketForHandler.close();
        return socketInput.readLine();
    }
}

