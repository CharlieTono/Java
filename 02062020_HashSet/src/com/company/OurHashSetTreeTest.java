package com.company;

import static org.junit.Assert.*;

public class OurHashSetTreeTest {

    Node testNode = new Node(10);
    OurHashSetTree ourHashSetTree = new OurHashSetTree(testNode);

    @org.junit.Test
    public void testSize_EmptySetWithVertex_One() {
        assertEquals(1, ourHashSetTree.size());
    }

    @org.junit.Test
    public void testAdd_SetWithOneVertexAndChild_TwoElement() {
        Object sample = 5;
        ourHashSetTree.add(sample);
        assertEquals(2, ourHashSetTree.size());
    }

    @org.junit.Test
    public void testAdd_SetWithOneVertexAndTreeElements_FourElement() {
        Object sample01 = 5;
        Object sample02 = 1;
        Object sample03 = 2;
        ourHashSetTree.add(sample01);
        ourHashSetTree.add(sample02);
        ourHashSetTree.add(sample03);
        assertEquals(4, ourHashSetTree.size());
    }
}