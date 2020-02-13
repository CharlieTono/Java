package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        CharPrinter runnable = new CharPrinter('*', 100);
        Thread th = new Thread(runnable);

        CharPrinter runnable02 = new CharPrinter('+', 100);
        Thread th02 = new Thread(runnable02);

        CharPrinter runnable03 = new CharPrinter('-', 100);
        Thread th03 = new Thread(runnable03);

        th.setDaemon(true); //when all other threads will end (except this(daemon) thread) the program will stop
        th02.setDaemon(true);
        th03.setDaemon(true);

        long currentTime = System.currentTimeMillis();
        th.start();
        th02.start();
        th03.start();

        // this method forces the main thread wait for the end of th execution
//        th.join();
//        th02.join();
//        th03.join();
        long executionTime = System.currentTimeMillis() - currentTime;
        System.out.println("Time of th execution is " + executionTime);
        System.out.println("End of Main");

    }
}
