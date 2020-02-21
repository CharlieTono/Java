package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        Messenger messenger = new Messenger();

        PrintWriter pw = new PrintWriter("text");

        Thread sender = new Sender(messenger);
        sender.start();

        Thread[] receiversUpper = new Thread[5];
        Thread[] receiversReverse = new Thread[5];

        for (int i = 0; i < receiversUpper.length; i++) {
            receiversUpper[i] = new ReceiverUpper(messenger, pw);
            receiversUpper[i].setDaemon(true);
        }

        for (int i = 0; i < receiversUpper.length; i++) {
            receiversUpper[i].start();
        }

        for (int i = 0; i < receiversReverse.length; i++) {
            receiversReverse[i] = new ReceiverReverse(messenger, pw);
            receiversReverse[i].setDaemon(true);
        }

        for (int i = 0; i < receiversReverse.length; i++) {
            receiversReverse[i].start();
        }

        sender.join();

        pw.close();
    }
}
