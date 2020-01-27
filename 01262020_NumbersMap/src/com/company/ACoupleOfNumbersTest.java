package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ACoupleOfNumbersTest {

    ACoupleOfNumbers numbers = new ACoupleOfNumbers();

    @Test
    public void testFindSingleNumber_noSingleNumbers_zero() {
        List<Integer> ints = Arrays.asList(1, 1, 2, 2, 3, 3);
        assertEquals(0, numbers.findSingleNumber(ints));
    }

    @Test
    public void testFindSingleNumber_oneSingledNumber_SingleNumberValue() {
        List<Integer> ints = Arrays.asList(1, 3, 1, 2, 2, -8, -8);
        assertEquals(3, numbers.findSingleNumber(ints));
    }

    @Test
    public void testFindSingleNumber_oneSingledNumberAndCoupleSameNumbers_SingleNumberValue() {
        List<Integer> ints = Arrays.asList(1, 3, 3, 1, 1, 2, 2, -8, -8);
        assertEquals(1, numbers.findSingleNumber(ints));
    }
}
