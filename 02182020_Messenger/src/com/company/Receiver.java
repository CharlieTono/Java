package com.company;

import java.io.PrintWriter;

public abstract class Receiver extends Thread{

    private Messenger messenger;
    private final PrintWriter pw;

    public Receiver(Messenger messenger, PrintWriter pw) {
        this.messenger = messenger;
        this.pw = pw;
    }

    public Messenger getMessenger() {
        return messenger;
    }

    public PrintWriter getPw() {
        return pw;
    }

}
