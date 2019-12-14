package com.company;

import static org.junit.Assert.*;

public class CensorTest {

    @org.junit.Test
    public void testIsLegal_nonEmptyListWithProhibitedText_findsProhibitedText() {

        String[] array = {"Astrology", "Horoscope"};
        Censor person = new Censor(array);
        String word = "Horoscope";
        assertFalse(person.isLegal(word));
    }

    @org.junit.Test
    public void testIsLegal_nonEmptyListWithoutProhibitedText_notFindsProhibitedText() {

        String[] array = {"Astrology", "Horoscope"};
        Censor person = new Censor(array);
        String word = "Physics";
        assertTrue(person.isLegal(word));
    }

}