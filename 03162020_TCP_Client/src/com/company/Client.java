package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    static final int PORT = 2000;
    static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(HOST, PORT); //creating calling connection

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter sender = new PrintWriter(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line;
        while ((line = consoleReader.readLine()) != null && !line.equals("exit")) {
            sender.println(line);
            sender.flush();
            System.out.println("from the server " + br.readLine());
        }
        socket.close();
    }
}
