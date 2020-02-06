package com.company;

import static org.junit.Assert.*;

public class OurHashSetTest {

    OurHashSet ourHashSet = new OurHashSet();

    @org.junit.Test
    public void testSize_EmptySet_Zero() {
        assertEquals(0, ourHashSet.size());
    }

    @org.junit.Test
    public void testAdd_EmptySet_OneElement() {
        Object sample = 5;
        ourHashSet.add(sample);
        assertEquals(1, ourHashSet.size());
    }

    @org.junit.Test
    public void testRemove_NonEmptySet_EmptySet() {
        Object sample01 = 5;
        Object sample02 = 10;
        ourHashSet.add(sample01);
        ourHashSet.add(sample02);
        ourHashSet.remove(sample01);
        assertEquals(1, ourHashSet.size());
        assertFalse(ourHashSet.contains(sample01));
    }

    @org.junit.Test
    public void testRemove_NonEmptySet_NonEmptySet() {
        Object sample01 = 5;
        Object sample02 = 10;
        Object sample03 = 15;
        ourHashSet.add(sample01);
        ourHashSet.add(sample02);
        ourHashSet.add(sample03);
        ourHashSet.remove(sample02);
        assertEquals(2, ourHashSet.size());
        assertFalse(ourHashSet.contains(sample02));
    }

    @org.junit.Test
    public void testContains_NonEmptyObject_True() {
        Object sample01 = 5;
        Object sample02 = 10;
        Object sample03 = 15;
        ourHashSet.add(sample01);
        ourHashSet.add(sample02);
        ourHashSet.add(sample03);
        assertEquals(3, ourHashSet.size());
        assertTrue(ourHashSet.contains(sample01));
        assertTrue(ourHashSet.contains(sample02));
        assertTrue(ourHashSet.contains(sample03));
    }

    @org.junit.Test
    public void testAddAll_NonEmptySet_SameElementsWereNotAdded() {
        Object sample01 = 5;
        Object sample02 = 10;
        Object sample03 = 15;
        ourHashSet.add(sample01);
        ourHashSet.add(sample02);
        ourHashSet.add(sample03);
        OurHashSet testSet = new OurHashSet();
        testSet.add(sample01);
        assertFalse(ourHashSet.addAll(testSet));
    }

    @org.junit.Test
    public void testAddAll_NonEmptySet_NewElementsWereAdded() {
        Object sample01 = 5;
        Object sample02 = 10;
        Object sample03 = 15;
        Object sample04 = 20;
        ourHashSet.add(sample01);
        ourHashSet.add(sample02);
        OurHashSet testSet = new OurHashSet();
        testSet.add(sample03);
        testSet.add(sample04);
        assertTrue(ourHashSet.addAll(testSet));
        assertTrue(ourHashSet.contains(sample03));
        assertTrue(ourHashSet.contains(sample04));
        assertEquals(4, ourHashSet.size());
    }

    @org.junit.Test
    public void testRemoveAll_NonEmptySet_AllSameElementsWereRemoved() {
        Object sample01 = 5;
        Object sample02 = 10;
        Object sample03 = 15;
        Object sample04 = 20;
        ourHashSet.add(sample01);
        ourHashSet.add(sample02);
        ourHashSet.add(sample03);
        OurHashSet testSet = new OurHashSet();
        testSet.add(sample01);
        testSet.add(sample04);
        assertTrue(ourHashSet.removeAll(testSet));
        assertFalse(ourHashSet.contains(sample01));
        assertTrue(ourHashSet.contains(sample02));
        assertTrue(ourHashSet.contains(sample03));
        assertEquals(2, ourHashSet.size());

    }

    @org.junit.Test
    public void retainAll_NonEmptySetsWithSameElements_SetContainsRetainedElementsOnly() {

        Object sample01 = 5;
        Object sample02 = 10;
        Object sample03 = 15;
        Object sample04 = 20;
        ourHashSet.add(sample01);
        ourHashSet.add(sample02);
        ourHashSet.add(sample03);
        OurHashSet testSet = new OurHashSet();
        testSet.add(sample01);
        testSet.add(sample02);
        testSet.add(sample04);
        assertTrue(ourHashSet.retainAll(testSet));
        assertTrue(ourHashSet.contains(sample01));
        assertTrue(ourHashSet.contains(sample02));
        assertFalse(ourHashSet.contains(sample03));
        assertFalse(ourHashSet.contains(sample04));
        assertEquals(2, ourHashSet.size());

    }
}