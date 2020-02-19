package com.company;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        Messenger messenger = new Messenger();

        Thread sender = new Sender(messenger);

        Thread[] receivers = new Thread[5];

        for (int i = 0; i < receivers.length; i++) {
            receivers[i] = new Receiver(messenger, "Text");
            receivers[i].setDaemon(true);
        }

        for (int i = 0; i < receivers.length; i++) {
            receivers[i].start();
        }
        sender.start();
    }
}
