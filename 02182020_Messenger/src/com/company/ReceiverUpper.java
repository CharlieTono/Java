package com.company;

import java.io.PrintWriter;

public class ReceiverUpper extends Receiver {

    public ReceiverUpper(Messenger messenger, PrintWriter pw) {
        super(messenger, pw);
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = getMessenger().removeMessage();
                message = message.toUpperCase();
                synchronized (ReceiverUpper.class) {
                    getPw().println(message + " " + getName());
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




