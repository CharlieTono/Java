package com.company;

public class OuterServer {

    private static final int OUTER_SERVER_PORT_TCP = 2900;
    private static final int OUTER_SERVER_PORT_UDP = 3800;

    public static void main(String[] args) {

        HandlerInfo lastHandler = new HandlerInfo();

        Thread balancerListener = new BalancerListener(OUTER_SERVER_PORT_UDP, lastHandler);
        balancerListener.start();

        Thread clientListener = new ClientListener(OUTER_SERVER_PORT_TCP, lastHandler);
        clientListener.start();

    }
}

