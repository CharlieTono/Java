package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    private static final int OUTER_SERVER_PORT = 2000;
    private static final String OUTER_SERVER_HOST = "localhost";
    private static final int MESSAGES_NUM = 10000;
    private static final int THREADS_NUM = 10;
    private static final String MESSAGE = "test";

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_NUM);

        for (int i = 0; i < MESSAGES_NUM; i++) {
            Runnable task = new ThreadClient(OUTER_SERVER_HOST, OUTER_SERVER_PORT, MESSAGE);
            executorService.execute(task);
        }
    }
}
