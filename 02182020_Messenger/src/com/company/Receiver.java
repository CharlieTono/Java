package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Receiver extends Thread {

    Messenger messenger;
    String fileName;

    public Receiver(Messenger messenger, String fileName) {
        this.messenger = messenger;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = messenger.removeMessage();
                System.out.println(message + " " + getName());
                PrintWriter pw = new PrintWriter(fileName);
                pw.println(message);
                pw.close();
            } catch (InterruptedException | FileNotFoundException e) {
                return;
            }
        }
    }
}



