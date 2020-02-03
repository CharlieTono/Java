package com.company;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OurStackTest {

    @org.junit.Test
    public void compare() {
    }

    @org.junit.Test
    public void testGetMax_nonEmptyObject_getMaxElement() {
        int[] source = {2, 5, 1};
        int[] sourceMax = {2, 5, 5};
        List<Integer> list = new ArrayList<>();
        List<Integer> listMax = new ArrayList<>();
        OurStack stackMax = new OurStack(list, listMax);

        assertEquals(5, stackMax.getMax());
    }
}