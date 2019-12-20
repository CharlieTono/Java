package com.company.collection;

import static org.junit.Assert.*;

public class ArrayQueueTest {

    @org.junit.Test
    public void testSize_NonEmptyQueue_Size() {

        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
        queue.add(5);
        assertEquals(1, queue.size());
    }

    @org.junit.Test
    public void testCapacity_NonEmptyQueue_Capacity() {

        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
        queue.add(5);
        assertEquals(10, queue.capacity());
    }

    @org.junit.Test
    public void testRelease_NonEmptyQueue_RemoveElementFromTheBeginning() {

        ArrayQueue<Integer> queue = new ArrayQueue<>(4);
        queue.add(5);
        queue.add(10);
        queue.add(15);
        queue.release();
        queue.release();
        queue.add(5);
        assertEquals(2, queue.size());
    }

    @org.junit.Test (expected = QueueEmptyException.class)
    public void testRelease_EmptyQueue_RemoveElementFromTheBeginning() {

        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
        queue.release();

    }
}