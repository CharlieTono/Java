package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Receiver extends Thread {

    Messenger messenger;
    String fileName;
    PrintWriter pw;

    public Receiver(Messenger messenger, String fileName) throws FileNotFoundException {
        this.messenger = messenger;
        this.fileName = fileName;
        pw = new PrintWriter(fileName);
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = messenger.removeMessage();
                System.out.println(message + " " + getName());
                messenger.history.add(message);
                pw.println(messenger.history);
                pw.flush();
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}



