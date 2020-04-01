package com.company;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientListener extends Thread {

    private int outerServerTcpPor;
    private HandlerInfo handler;

    public ClientListener(int outerServerPortNumber, HandlerInfo lastHandler) {
        this.outerServerTcpPor = outerServerPortNumber;
        this.handler = lastHandler;
    }

    @Override
    public void run() {
        ServerSocket mainSocket;
        try {
            mainSocket = new ServerSocket(outerServerTcpPor);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        ExecutorService executor = Executors.newCachedThreadPool();

        while (true) {
            try {
                Socket socketForClient = mainSocket.accept();
                TcpTask task = new TcpTask(socketForClient, handler);
                executor.execute(task);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
