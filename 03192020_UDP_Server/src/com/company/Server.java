package com.company;

import java.io.IOException;
import java.net.DatagramSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    static final int PORT = 3000;

    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        DatagramSocket datagramSocket = new DatagramSocket(PORT);
        ServerService thSer = new ServerService(datagramSocket);
        executorService.execute(thSer);

    }
}
