package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    static final int PORT = 2000; //number of the port (till 65500 ~ 2^16)

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket serverSocket = new ServerSocket(PORT); // reservation for our Java - program

        ExecutorService executor = Executors.newFixedThreadPool(10);

        while (true) {
            Socket socket = serverSocket.accept(); // connection with port - program is going to process only after call
            ThreadServer thSer = new ThreadServer(socket);
            executor.execute(thSer);
//            Thread th = new Thread(thSer); - without executor
//            th.start();
        }
    }
}
