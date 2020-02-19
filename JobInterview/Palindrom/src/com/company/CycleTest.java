package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class CycleTest {

    Cycle cycle = new Cycle();

    @Test
    public void testWheelCycle_Equals_true() {
        String text01 = "test";
        String text02 = "stte";
        assertTrue(cycle.wheelCycle(text01, text02));
    }

    @Test
    public void testIsSubsequenceRecursive_Equals_true() {
        String text01 = "Hello";
        String text02 = "Hll";
        assertTrue(cycle.isSubsequence(text01, text02));
    }

    @Test
    public void testIsSubsequenceRecursive_NonEquals_false() {
        String text01 = "Hello";
        String text02 = "Hllm";
        assertFalse(cycle.isSubsequence(text01, text02));
    }

}