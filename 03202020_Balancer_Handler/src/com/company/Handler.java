package com.company;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Handler {

    private static final int UDP_BALANCER_PORT = 3700;
    private static final String BALANCER_HOST = "localhost";

    public static void main(String[] args) {

        int tcpHandlerPort = Integer.parseInt(args[0]);
        AtomicInteger taskNum = new AtomicInteger();

        new TcpListener(tcpHandlerPort, taskNum).start();

        ScheduledExecutorService udpScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        udpScheduledExecutor.scheduleAtFixedRate(
                new UdpSender(taskNum, BALANCER_HOST, UDP_BALANCER_PORT, tcpHandlerPort),
                0,
                1,
                TimeUnit.SECONDS);
    }
}
