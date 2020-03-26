package com.company;

import com.company.handler.HandlerListener;
import com.company.handler.HandlerPriorityQueue;

public class Balancer {

    public static void main(String[] args) {

        // the data structure keeping the info about handlers
        HandlerPriorityQueue servers = new HandlerPriorityQueue();

        new HandlerListener(servers).start();
        new HandlersCleaner(servers).start();
        new OuterSenderSender(servers).start();

    }
}
