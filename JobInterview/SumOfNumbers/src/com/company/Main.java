package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        Deque<Integer> myQueue = new ArrayDeque<>();
        myQueue.addFirst(10);
        myQueue.addFirst(8);
        myQueue.addFirst(5);
        myQueue.addFirst(1);

        int number = 9;

        System.out.println(checkArray(myQueue, number));
    }

    public static boolean checkArray(Deque<Integer> myQueue, int number) {

        while (myQueue.size() > 1) {
            if (myQueue.getFirst() + myQueue.getLast() < number) {
                myQueue.removeFirst();
            } else if (myQueue.getFirst() + myQueue.getLast() > number) {
                myQueue.removeLast();
            } else {
                return true;
            }
        }
        return false;
    }

}
