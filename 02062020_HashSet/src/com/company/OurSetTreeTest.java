package com.company;

import static org.junit.Assert.*;

public class OurSetTreeTest {

    private OurSetTree <Integer>ourSetTree = new OurSetTree<>();

    @org.junit.Test
    public void testSize_EmptySet_Zero() {
        assertEquals(0, ourSetTree.size());
    }

    @org.junit.Test
    public void testAdd_SetWithOneVertex_OneElement() {
        Integer sample = 5;
        ourSetTree.add(sample);
        assertEquals(1, ourSetTree.size());
    }

    @org.junit.Test
    public void testAdd_SetWithTreeElements_TreeElement() {
        Integer sample01 = 5;
        Integer sample02 = 1;
        Integer sample03 = 2;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        assertEquals(3, ourSetTree.size());
    }

    @org.junit.Test
    public void testContains_SetWithTreeElements_True() {
        Integer sample01 = 5;
        Integer sample02 = 1;
        Integer sample03 = 2;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        assertTrue(ourSetTree.contains(sample01));
    }

    @org.junit.Test
    public void testContains_SetWithTreeElements_False() {
        Integer sample01 = 5;
        Integer sample02 = 1;
        Integer sample03 = 2;
        Integer sample04 = 8;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        assertFalse(ourSetTree.contains(sample04));
    }

    @org.junit.Test
    public void testRemove_SetThreeElementsWithoutBothChildrenRemoveLastElement_TwoElements() {
        Integer sample01 = 10;
        Integer sample02 = 18;
        Integer sample03 = 19;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        ourSetTree.remove(sample03);
        assertEquals(2, ourSetTree.size());
        assertFalse(ourSetTree.contains(sample03));
    }

    @org.junit.Test
    public void testRemove_SetThreeElementsWithoutBothChildrenRemoveMiddleElement_TwoElements() {
        Integer sample01 = 10;
        Integer sample02 = 18;
        Integer sample03 = 19;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        ourSetTree.remove(sample02);
        assertEquals(2, ourSetTree.size());
        assertFalse(ourSetTree.contains(sample02));
    }

    @org.junit.Test
    public void testRemove_SetThreeElementsWithoutBothChildrenRemoveFirstElement_TwoElements() {
        Integer sample01 = 10;
        Integer sample02 = 18;
        Integer sample03 = 19;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        ourSetTree.remove(sample01);
        assertEquals(2, ourSetTree.size());
        assertFalse(ourSetTree.contains(sample01));
    }

    @org.junit.Test
    public void testRemove_SetFourElementsWithBothChildrenRemoveLastElement_ThreeElements() {
        Integer sample01 = 10;
        Integer sample02 = 18;
        Integer sample03 = 19;
        Integer sample04 = 17;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        ourSetTree.add(sample04);
        ourSetTree.remove(sample03);
        assertEquals(3, ourSetTree.size());
        assertFalse(ourSetTree.contains(sample03));
    }

    @org.junit.Test
    public void testRemove_SetFourElementsWithBothChildrenRemoveMiddleElement_ThreeElements() {
        Integer sample01 = 10;
        Integer sample02 = 18;
        Integer sample03 = 19;
        Integer sample04 = 17;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        ourSetTree.add(sample04);
        ourSetTree.remove(sample02);
        assertEquals(3, ourSetTree.size());
        assertFalse(ourSetTree.contains(sample02));
    }

    @org.junit.Test
    public void testRemove_SetFourElementsWithBothChildrenRemoveFirstElement_ThreeElements() {
        Integer sample01 = 10;
        Integer sample02 = 18;
        Integer sample03 = 19;
        Integer sample04 = 17;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        ourSetTree.add(sample04);
        ourSetTree.remove(sample01);
        assertEquals(3, ourSetTree.size());
        assertFalse(ourSetTree.contains(sample01));
    }

    @org.junit.Test
    public void testAddAll_NonEmptySet_SameElementsWereNotAdded() {
        Integer sample01 = 5;
        Integer sample02 = 10;
        Integer sample03 = 15;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        OurHashSet<Integer> testSet = new OurHashSet<>();
        testSet.add(sample01);
        assertFalse(ourSetTree.addAll(testSet));
    }

    @org.junit.Test
    public void testAddAll_NonEmptySet_NewElementsWereAdded() {
        Integer sample01 = 5;
        Integer sample02 = 10;
        Integer sample03 = 15;
        Integer sample04 = 20;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        OurHashSet <Integer>testSet = new OurHashSet<>();
        testSet.add(sample03);
        testSet.add(sample04);
        assertTrue(ourSetTree.addAll(testSet));
        assertTrue(ourSetTree.contains(sample03));
        assertTrue(ourSetTree.contains(sample04));
        assertEquals(4, ourSetTree.size());
    }

    @org.junit.Test
    public void testRemoveAll_NonEmptySet_AllSameElementsWereRemoved() {
        Integer sample01 = 5;
        Integer sample02 = 10;
        Integer sample03 = 15;
        Integer sample04 = 20;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        OurHashSet<Integer> testSet = new OurHashSet<>();
        testSet.add(sample01);
        testSet.add(sample04);
        assertTrue(ourSetTree.removeAll(testSet));
        assertFalse(ourSetTree.contains(sample01));
        assertTrue(ourSetTree.contains(sample02));
        assertTrue(ourSetTree.contains(sample03));
        assertEquals(2, ourSetTree.size());

    }

    @org.junit.Test
    public void retainAll_NonEmptySetsWithSameElements_SetContainsRetainedElementsOnly() {

        Integer sample01 = 5;
        Integer sample02 = 10;
        Integer sample03 = 15;
        Integer sample04 = 20;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        OurHashSet <Integer>testSet = new OurHashSet<>();
        testSet.add(sample01);
        testSet.add(sample02);
        testSet.add(sample04);
        assertTrue(ourSetTree.retainAll(testSet));
        assertTrue(ourSetTree.contains(sample01));
        assertTrue(ourSetTree.contains(sample02));
        assertFalse(ourSetTree.contains(sample03));
        assertFalse(ourSetTree.contains(sample04));
        assertEquals(2, ourSetTree.size());

    }

    @org.junit.Test
    public void retainAll_NonEmptySetsWithNoElements_SetContainsZeroElementsOnly() {

        Integer sample01 = 5;
        Integer sample02 = 10;
        Integer sample03 = 15;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        OurHashSet<Integer> testSet = new OurHashSet<>();
        testSet.add(sample01);
        testSet.add(sample02);
        testSet.add(sample03);
        assertFalse(ourSetTree.retainAll(testSet));
        assertEquals(2, ourSetTree.size());

    }

}