package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;

public class ThreadOuterServerService implements Runnable {

    private Socket socket;
    private InetAddress serverIp;
    private int balancerPortNumber;
    private int handlerFirstPortNumber;
    private int handlerSecondPortNumber;
    private int handlerThirdPortNumber;
    private Deque<String> tasks = new ArrayDeque<>();

    public ThreadOuterServerService(Socket socket, InetAddress serverIp, int balancerPortNumber, int handlerFirstPortNumber, int handlerSecondPortNumber, int handlerThirdPortNumber) {
        this.socket = socket;
        this.serverIp = serverIp;
        this.balancerPortNumber = balancerPortNumber;
        this.handlerFirstPortNumber = handlerFirstPortNumber;
        this.handlerSecondPortNumber = handlerSecondPortNumber;
        this.handlerThirdPortNumber = handlerThirdPortNumber;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream ps = new PrintStream(socket.getOutputStream());
            String line;
            while ((line = br.readLine()) != null) {
                ps.println(line + " task is in process");
                tasks.addLast(line);
                ps.flush();
                if (tasks.size() != 0) {
                    //UDP connection with Balancer - request for a free Handler
                    UDP_Balancer_Connection udp_balancer_connection = new UDP_Balancer_Connection(balancerPortNumber, serverIp);
                    String handlerInfoResult = udp_balancer_connection.requestForFreeHandlerFromBalancer();
                    //TCP connection with Free Handler
                    TCP_Handler_Connection tcp_handler_connection = new TCP_Handler_Connection(handlerFirstPortNumber, handlerSecondPortNumber, handlerThirdPortNumber, handlerInfoResult, tasks.getLast());
                    tcp_handler_connection.sendTaskToFreeHandler();
                } else {
                    System.out.println("no messages");
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
