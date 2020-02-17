package com.company;

public class Incrementer {

    private int counter;
//    Object mutex = new Object();

    public synchronized void increment() {
        counter++;
    }

//    the same as:
//    public void increment() {
//        synchronized (this) {
//            counter++;
//        }
//    }

//    public void increment() { mutex - if it is not necessary to synchronized full method
//        synchronized (mutex) {
//            counter++;
//        }
//    }

//    public void decrement () { mutex can close all the methods/loops, if it mention in the code
//        synchronized (mutex) { if mutex is free, thread can use it (but only one thread), for other threads it will be closed
//            counter--;
//        }
//    }

    public int getCounter() {
        return counter;
    }
}
