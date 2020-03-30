package com.company;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskHandler implements Runnable {

    Socket socketIn;
    private AtomicInteger tasksNum;

    public TaskHandler(Socket socketIn, AtomicInteger tasksNum) {
        this.socketIn = socketIn;
        this.tasksNum = tasksNum;
    }

    @Override
    public void run() {
        try {
            BufferedReader fromOuterServer = new BufferedReader(new InputStreamReader(socketIn.getInputStream()));
            PrintStream toOuterServer = new PrintStream(socketIn.getOutputStream());
            String line = fromOuterServer.readLine();
            line = line.toLowerCase();
            TimeUnit.MICROSECONDS.sleep(20);
            toOuterServer.println(line);
            socketIn.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            tasksNum.decrementAndGet();
        }
    }
}
