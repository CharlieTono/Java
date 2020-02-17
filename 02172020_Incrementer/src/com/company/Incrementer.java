package com.company;

import java.util.concurrent.locks.ReentrantLock;

public class Incrementer {

    private int counter;
    private int counter2;

    Object mu01 = new Object();
    Object mu02 = new Object();

    ReentrantLock lock2 = new ReentrantLock();
    ReentrantLock lock1 = new ReentrantLock();

    public int getCounter() {
        return counter;
    }

    public int getCounter2() {
        return counter2;
    }

    //    public void increment() {
//        synchronized (mu01) {
//            counter++;
//        }
//    }
//
//    public void increment2() {
//        synchronized (mu02) {
//            counter2++;
//        }
//    }
//
    public void increment() {
        lock1.lock();
        counter2++;
        lock1.unlock();
    }

    public void increment2() {
        lock2.lock();
        counter++;
        lock2.unlock();
    }
//    the same as
//    public void increment() {
//        synchronized (this) {
//            counter++;
//        }
//    }
//    public void decrement() {
//        synchronized (mu02) {
//            counter--;
//        }
//    }

//    Object mutex = new Object();

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
}
