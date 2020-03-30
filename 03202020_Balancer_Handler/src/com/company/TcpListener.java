package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TcpListener extends Thread {

    private int handlerTcpPort;
    private AtomicInteger tasksNum;

    public TcpListener(int handlerTcpPort, AtomicInteger tasksNum) {
        this.handlerTcpPort = handlerTcpPort;
        this.tasksNum = tasksNum;
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(handlerTcpPort);
            ExecutorService executorService = Executors.newFixedThreadPool(10);

            while (true) {
                Socket socketIn = server.accept();
                Runnable taskHandler = new TaskHandler(socketIn, tasksNum);
                executorService.execute(taskHandler);
                tasksNum.incrementAndGet();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
