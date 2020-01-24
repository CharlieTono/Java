package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {

    Main main = new Main();

    @Test
    public void testCheckRepeatedNumber_NonRepeatedNumbers_zero() {
        List<Integer> list = Arrays.asList(1, 3, -20, 8);
        assertEquals(0, main.checkRepeatedNumber(list));
    }

    @Test
    public void testCheckRepeatedNumber_RepeatedNumbers_QtyOfNumbers() {
        List<Integer> list = Arrays.asList(1, 3, 3, -20, 8);
        assertEquals(1, main.checkRepeatedNumber(list));
    }

    @Test
    public void testCheckRepeatedNumber_RepeatedNumbersSeveralTimes_QtyOfNumbers() {
        List<Integer> list = Arrays.asList(1, 3, 3, -20, 8, 8);
        assertEquals(2, main.checkRepeatedNumber(list));
    }

}