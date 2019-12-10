package com.company.comparator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountryCodeComparatorTest {

    @Test
    public void testCompare_twoIntObjects_return0() {

        CountryCodeComparator countryCodeComparator = new CountryCodeComparator();
        Object first = 7;
        Object second = 7;
        assertEquals(0, countryCodeComparator.compare(first, second));
    }

    @Test
    public void testCompare_twoIntObjects_return1() {

        CountryCodeComparator countryCodeComparator = new CountryCodeComparator();
        Object first = 8;
        Object second = 7;
        assertEquals(1, countryCodeComparator.compare(first, second));
    }

    @Test
    public void testCompare_twoIntObjects_returnMinus1() {

        CountryCodeComparator countryCodeComparator = new CountryCodeComparator();
        Object first = 6;
        Object second = 7;
        assertEquals(-1, countryCodeComparator.compare(first, second));
    }
}