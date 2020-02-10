package com.company;

import static org.junit.Assert.*;

public class OurSetTreeTest {

    OurSetTree ourSetTree = new OurSetTree();

    @org.junit.Test
    public void testSize_EmptySet_Zero() {
        assertEquals(0, ourSetTree.size());
    }

    @org.junit.Test
    public void testAdd_SetWithOneVertex_OneElement() {
        Object sample = 5;
        ourSetTree.add(sample);
        assertEquals(1, ourSetTree.size());
    }

    @org.junit.Test
    public void testAdd_SetWithTreeElements_TreeElement() {
        Object sample01 = 5;
        Object sample02 = 1;
        Object sample03 = 2;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        assertEquals(3, ourSetTree.size());
    }

    @org.junit.Test
    public void testContains_SetWithTreeElements_True() {
        Object sample01 = 5;
        Object sample02 = 1;
        Object sample03 = 2;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        assertTrue(ourSetTree.contains(sample01));
    }

    @org.junit.Test
    public void testContains_SetWithTreeElements_False() {
        Object sample01 = 5;
        Object sample02 = 1;
        Object sample03 = 2;
        Object sample04 = 8;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        assertFalse(ourSetTree.contains(sample04));
    }

    @org.junit.Test
    public void testRemove_SetTreeElementsWithoutBothChildrenRemoveLastElement_TwoElements() {
        Object sample01 = 5;
        Object sample02 = 1;
        Object sample03 = 2;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        ourSetTree.remove(sample03);
        assertEquals(2, ourSetTree.size());
        assertFalse(ourSetTree.contains(sample03));
    }

    @org.junit.Test
    public void testRemove_SetTreeElementsWithoutBothChildrenRemoveMiddleElement_TwoElements() {
        Object sample01 = 5;
        Object sample02 = 1;
        Object sample03 = 2;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        ourSetTree.remove(sample02);
        assertEquals(2, ourSetTree.size());
        assertFalse(ourSetTree.contains(sample02));
    }

    @org.junit.Test
    public void testRemove_SetTreeElementsWithoutBothChildrenRemoveFirstElement_TwoElements() {
        Object sample01 = 5;
        Object sample02 = 1;
        Object sample03 = 2;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        ourSetTree.remove(sample01);
        assertEquals(2, ourSetTree.size());
        assertFalse(ourSetTree.contains(sample01));
    }

}