package com.company;

import java.util.ArrayList;
import java.util.List;

public class Messenger {

    private final Object mutex = new Object();

    private volatile String message;

    List<String> history = new ArrayList<>();

    public void addMessage(String message) {
        synchronized (mutex) {
            this.message = message;
            mutex.notify();
        }
    }

    public String removeMessage() throws InterruptedException {
        synchronized (mutex) {
            while (message == null) {
                mutex.wait();
            }
            String res = message;
            message = null;
            return res;
        }
    }
}
