package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class CycleTest {

    Cycle cycle = new Cycle();

    @Test
    public void testWheelCycle_Equals_true() {
        String text01 = new String ("test");
        String text02 = new String ("stte");
        assertTrue(cycle.wheelCycle(text01, text02));
    }

    @Test
    public void testPatternCycle_Equals_true() {
        String text01 = new String ("Hello");
        String text02 = new String ("Hll");
        assertTrue(cycle.patternCycle(text01, text02));
    }

    @Test
    public void testPatternCycle_NonEquals_false() {
        String text01 = new String ("Hello");
        String text02 = new String ("Hllm");
        assertFalse(cycle.patternCycle(text01, text02));
    }

}