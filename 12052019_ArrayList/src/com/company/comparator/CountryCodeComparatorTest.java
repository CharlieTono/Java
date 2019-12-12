package com.company.comparator;

import com.company.CountryCode;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountryCodeComparatorTest {

    CountryCodeComparator countryCodeComparator = new CountryCodeComparator();

    @Test
    public void testCompare_twoIntObjects_equals() {

        CountryCode usa = new CountryCode("USA", 1);
        CountryCode russia = new CountryCode("Russia", 7);
        CountryCode anotherUsa = new CountryCode("USA", 1);
        CountryCode anotherRussia = new CountryCode("Russia", 7);

        assertTrue(countryCodeComparator.compare(usa, usa) == 0);
        assertTrue(countryCodeComparator.compare(usa, anotherUsa) == 0);
        assertTrue(countryCodeComparator.compare(anotherRussia, anotherRussia) == 0);
    }

    @Test
    public void testCompare_twoIntObjects_grater() {

        CountryCode usa = new CountryCode("USA", 1);
        CountryCode russia = new CountryCode("Russia", 7);
        CountryCode germany = new CountryCode("Germany", 49);
        assertTrue(countryCodeComparator.compare(usa, russia) < 0);

    }

    @Test
    public void testCompare_twoIntObjects_less() {

        CountryCode usa = new CountryCode("USA", 1);
        CountryCode russia = new CountryCode("Russia", 7);
        CountryCode germany = new CountryCode("Germany", 49);
        assertTrue(countryCodeComparator.compare(usa, russia) < 0);

    }
}