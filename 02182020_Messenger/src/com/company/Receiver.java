package com.company;

import java.io.PrintWriter;

public class Receiver extends Thread {

    private Messenger messenger;
    private final PrintWriter pw;

    public Receiver(Messenger messenger, PrintWriter pw) {
        this.messenger = messenger;
        this.pw = pw;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = messenger.removeMessage();
                synchronized (Receiver.class) {
                    pw.println(message + " " + getName());
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

//    public static synchronized void test() {
//    }
//    same as :
//    public static void test() {
//        synchronized (Receiver.class)
//    }




