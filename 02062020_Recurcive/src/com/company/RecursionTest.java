package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecursionTest {

    Recursion method = new Recursion();

    @Test
    public void testSquare() {

        int a = 5;
        assertEquals(25, method.square(a));
    }

    @Test
    public void testPower() {

        int a = 2;
        int b = 3;
        assertEquals(8, method.power(a, b));
    }

}