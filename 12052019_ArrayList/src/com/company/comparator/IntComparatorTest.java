package com.company.comparator;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntComparatorTest {

    IntComparator intComparator = new IntComparator();

    @Test
    public void testCompare_twoIntObjects_equals() {

        Object first = 7;
        Object second = 7;
        assertEquals(0, intComparator.compare(first, second));
        assertTrue(intComparator.compare(7, 7) == 0);
    }

    @Test
    public void testCompare_twoIntObjects_graterThenFirst() {

        IntComparator intComparator = new IntComparator();
        Object first = 8;
        Object second = 7;
        assertEquals(1, intComparator.compare(first, second));
        assertTrue(intComparator.compare(1, 7) < 0);
    }

    @Test
    public void testCompare_twoIntObjects_lessThenFirst() {

        IntComparator intComparator = new IntComparator();
        Object first = 6;
        Object second = 7;
        assertEquals(-1, intComparator.compare(first, second));
        assertTrue(intComparator.compare(7, 1) > 0);
    }

}