package com.company;

import java.util.*;

import static org.junit.Assert.*;

public class OurStackTest {

    @org.junit.Test
    public void testGetMax_nonEmptyObject_getMaxElementFromTheBeginning() {

        OurStack <Integer>stackMax = new OurStack();
        stackMax.addLast(10);
        stackMax.addLast(5);
        stackMax.addLast(1);
        assertEquals(10, (long)stackMax.getMax());
    }

    @org.junit.Test
    public void testGetMax_nonEmptyObject_getMaxElementFromTheMiddle() {

        OurStack <Integer>stackMax = new OurStack();
        stackMax.addLast(4);
        stackMax.addLast(5);
        stackMax.addLast(1);
        assertEquals(5, (long)stackMax.getMax());
    }

    @org.junit.Test
    public void testGetMax_nonEmptyObject_getMaxElementFromTheEnd() {

        OurStack <Integer>stackMax = new OurStack();
        stackMax.addLast(4);
        stackMax.addLast(5);
        stackMax.addLast(10);
        assertEquals(10, (long)stackMax.getMax());
    }
}