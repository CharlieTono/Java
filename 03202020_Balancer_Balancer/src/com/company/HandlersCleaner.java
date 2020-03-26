package com.company;

import com.company.handler.HandlerPriorityQueue;

import java.time.Duration;

public class HandlersCleaner extends Thread {
    private static final long CLEAR_TIME = 5000;
    HandlerPriorityQueue servers;

    public HandlersCleaner(HandlerPriorityQueue servers) {
        this.servers = servers;
    }

    @Override
    public void run() {

        try {
            while (true) {
                servers.removeUnused(Duration.ofMillis(CLEAR_TIME));
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

