package com.company;

import com.company.handler.HandlerListener;
import com.company.handler.HandlerPriorityQueue;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Balancer {

    private static final long CLEAR_TIME = 5000;

    public static void main(String[] args) {

        // the data structure keeping the info about handlers
        HandlerPriorityQueue servers = new HandlerPriorityQueue();

        new HandlerListener(servers).start();

        Runnable handlersCleaner = () -> servers.removeUnused(Duration.ofMillis(CLEAR_TIME));
        ScheduledExecutorService cleanerExecutor = Executors.newSingleThreadScheduledExecutor();
        cleanerExecutor.scheduleAtFixedRate(handlersCleaner, 0, 1, TimeUnit.SECONDS);

        ScheduledExecutorService outerServerExecutor = Executors.newSingleThreadScheduledExecutor();
        outerServerExecutor.scheduleAtFixedRate(
                new OuterSenderSender(servers),
                0,
                1,
                TimeUnit.SECONDS
        );
    }
}
