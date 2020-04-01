package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TcpTask implements Runnable {

    private static final String NO_HANDLER = "No handler available";
    private Socket clientSocket;
    private HandlerInfo handlerInfo;

    public TcpTask(Socket clientSocket, HandlerInfo handlerInfo) {
        this.clientSocket = clientSocket;
        this.handlerInfo = handlerInfo;
    }

    @Override
    public void run() {
        try {
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintStream toClient = new PrintStream(clientSocket.getOutputStream());

            String host = handlerInfo.getHost();
            int port = handlerInfo.getPort();

            if (host == null) {
                toClient.println(NO_HANDLER);
                clientSocket.close();
                return;
            }

            Socket handlerSocket = new Socket(host, port);

            BufferedReader fromHandler = new BufferedReader(new InputStreamReader(handlerSocket.getInputStream()));
            PrintStream toHandler = new PrintStream(handlerSocket.getOutputStream());

            String lineFromClient = fromClient.readLine();
            toHandler.println(lineFromClient);

            String lineFromHandler = fromHandler.readLine();
            handlerSocket.close();
            toClient.println(lineFromHandler);
            toClient.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
