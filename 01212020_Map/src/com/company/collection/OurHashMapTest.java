package com.company.collection;

import static org.junit.Assert.*;

public class OurHashMapTest {

    @org.junit.Test
    public void testSize_EmptyMap_NullSize() {

        OurHashMap ourMap = new OurHashMap();
        assertEquals(0, ourMap.size());
    }

    @org.junit.Test
    public void testSize_NonEmptyMap_Size() {

        OurHashMap ourMap = new OurHashMap();
        ourMap.put(10, 10);
        assertEquals(1, ourMap.size());
    }

    @org.junit.Test
    public void testContains_NonEmptyMap_Boolean() {

        OurHashMap ourMap = new OurHashMap();
        ourMap.put(10, 20);
        assertTrue(ourMap.contains(10));
    }

    @org.junit.Test
    public void testRemove_NonEmptyMap_() {

        OurHashMap ourMap = new OurHashMap();
        ourMap.put(10, 20);
        ourMap.put(20, 30);
        ourMap.remove(20);
        assertTrue(ourMap.contains(10));
        assertEquals(1, ourMap.size());
    }
}