package com.company;

import java.io.PrintWriter;

public class ReceiverReverse extends Receiver {

    public ReceiverReverse(Messenger messenger, PrintWriter pw) {
        super(messenger, pw);
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = getMessenger().removeMessage();
                StringBuilder newMessage = new StringBuilder(message);
                newMessage.reverse();
                synchronized (ReceiverUpper.class) {
                    getPw().println(newMessage + " " + getName());
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

