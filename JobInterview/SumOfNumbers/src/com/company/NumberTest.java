package com.company;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.*;

public class NumberTest {

    Number numbers = new Number();

    @Test
    public void testCheckArray_NonSumInArray_False() {

        Deque<Integer> myQueue = new ArrayDeque<>();
        myQueue.addFirst(10);
        myQueue.addFirst(8);
        myQueue.addFirst(5);
        myQueue.addFirst(2);

        int ourNumber = 9;

        assertFalse(numbers.checkArray(myQueue, ourNumber));

    }

    @Test
    public void testCheckArray_SumInArray_True() {

        Deque<Integer> myQueue = new ArrayDeque<>();
        myQueue.addFirst(10);
        myQueue.addFirst(8);
        myQueue.addFirst(5);
        myQueue.addFirst(1);

        int ourNumber = 9;

        assertTrue(numbers.checkArray(myQueue, ourNumber));

    }

}