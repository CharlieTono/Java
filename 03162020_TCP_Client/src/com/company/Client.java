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

        PrintWriter socketOutPut = new PrintWriter(socket.getOutputStream());
        BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line;
        while ((line = consoleReader.readLine()) != null && !line.equals("exit")) {
            socketOutPut.println(line);
            socketOutPut.flush();
            System.out.println("from the server " + socketInput.readLine());
        }
        socket.close();
    }
}
