package com.company.comparator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntComparatorTest {

    @Test
    public void testCompare_twoIntObjects_return0() {

        IntComparator intComparator = new IntComparator();
        Object first = 7;
        Object second = 7;
        assertEquals(0, intComparator.compare(first, second));
    }

    @Test
    public void testCompare_twoIntObjects_return1() {

        IntComparator intComparator = new IntComparator();
        Object first = 8;
        Object second = 7;
        assertEquals(1, intComparator.compare(first, second));
    }

    @Test
    public void testCompare_twoIntObjects_returnMinus1() {

        IntComparator intComparator = new IntComparator();
        Object first = 6;
        Object second = 7;
        assertEquals(-1, intComparator.compare(first, second));
    }

}