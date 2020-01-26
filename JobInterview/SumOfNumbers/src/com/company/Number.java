package com.company;

import java.util.Deque;

public class Number {

    public boolean checkArray(Deque<Integer> myQueue, int number) {

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
