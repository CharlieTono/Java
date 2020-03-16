package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    static final int PORT = 2000; //number of the port (till 65500 ~ 2^16)

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(PORT); // reservation for our Java - program
        Socket socket = serverSocket.accept(); // connection with port - program is going to process only after call

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //reading
        PrintWriter pw = new PrintWriter(socket.getOutputStream()); //answering

        String line;
        while ((line = br.readLine()) != null) { //till the end of the data
            pw.println(line + "hello");
        }

        socket.close(); //close connection

    }
}
