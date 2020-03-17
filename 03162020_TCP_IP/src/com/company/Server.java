package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static final int PORT = 2000; //number of the port (till 65500 ~ 2^16)

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(PORT); // reservation for our Java - program
        Socket socket = serverSocket.accept(); // connection with port - program is going to process only after call

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //reading
        PrintStream pw = new PrintStream(socket.getOutputStream()); //answering

        String line;
        while ((line = br.readLine()) != null) { //till the end of the data
            pw.println(line + " hello");
            pw.flush();
        }

        socket.close(); //close connection

    }
}
