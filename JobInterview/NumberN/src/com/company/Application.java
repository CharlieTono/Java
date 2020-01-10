package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

public class Application {

    public static void main(String[] args) {

        Deque<Integer> myQueue = new ArrayDeque<>();
        myQueue.addFirst(20);
        myQueue.addFirst(15);
        myQueue.addFirst(11);
        myQueue.addFirst(9);
        myQueue.addFirst(7);
        myQueue.addFirst(4);
        myQueue.addFirst(2);

        int number = 77;

        System.out.println(checkArray(myQueue, number));
    }

    public static boolean checkArray(Deque<Integer> myQueue, int number) {

        while (myQueue.size() > 1) {
            if (myQueue.getFirst() * myQueue.getLast() < number) {
                myQueue.removeFirst();
            } else if (myQueue.getFirst() * myQueue.getLast() > number) {
                myQueue.removeLast();
            } else {
                return true;
            }
        }
        return false;
    }
}
