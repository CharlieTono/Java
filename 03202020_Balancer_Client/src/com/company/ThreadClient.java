package com.company;

import java.io.*;
import java.net.Socket;

public class ThreadClient implements Runnable {

    private int outerServerPort;
    private String outerServerHost;
    private String message;

    public ThreadClient(String outerServerHost, int outerServerPort, String message) {
        this.outerServerPort = outerServerPort;
        this.outerServerHost = outerServerHost;
        this.message = message;
    }

    @Override
    public void run() {

        try {
            Socket socket = new Socket(outerServerHost, outerServerPort);
            PrintStream streamOut = new PrintStream(socket.getOutputStream());
            BufferedReader streamIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            streamOut.println(message);
            String line = streamIn.readLine();
            System.out.println("Answer from server: " + line);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

