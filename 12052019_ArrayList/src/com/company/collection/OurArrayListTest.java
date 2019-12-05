package com.company.collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class OurArrayListTest {

    @Test
    public void testSize_emptyObject_returnsSize() {
        OurArrayList list = new OurArrayList();
        assertEquals(0, list.size());
    }

    @Test
    public void testSize_nonEmptyObject_returnsSize() {
        Object first = new Object();
        Object second = new Object();
        OurArrayList list = new OurArrayList();
        list.append(first);
        list.append(second);
        assertEquals(2, list.size());
    }

    @Test
    public void testGet_nonEmptyObject_getsAllElements() {
        Object first = new Object();
        Object second = new Object();
        OurArrayList list = new OurArrayList();
        list.append(first);
        list.append(second);
        assertEquals(first, list.get(0));
        assertEquals(second, list.get(1));
    }

    @Test
    public void testSet_nonEmptyObject_setsFirstElement() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        Object newObject = new Object();
        OurArrayList list = new OurArrayList();
        list.append(first);
        list.append(second);
        list.append(third);
        list.set(newObject, 0);
        assertEquals(newObject, list.get(0));
        assertEquals(second, list.get(1));
        assertEquals(third, list.get(2));
    }

    @Test
    public void testSet_nonEmptyObject_setsMiddleElement() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        Object newObject = new Object();
        OurArrayList list = new OurArrayList();
        list.append(first);
        list.append(second);
        list.append(third);
        list.set(newObject, 1);
        assertEquals(first, list.get(0));
        assertEquals(newObject, list.get(1));
        assertEquals(third, list.get(2));
    }

    @Test
    public void testSet_nonEmptyObject_setsLastElement() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        Object newObject = new Object();
        OurArrayList list = new OurArrayList();
        list.append(first);
        list.append(second);
        list.append(third);
        list.set(newObject, 2);
        assertEquals(first, list.get(0));
        assertEquals(second, list.get(1));
        assertEquals(newObject, list.get(2));
    }

    @Test
    public void testAppend_emptyObject_addsElement() {
        Object first = new Object();
        OurArrayList list = new OurArrayList();
        list.append(first);
        assertEquals(first, list.get(0));
    }

    @Test
    public void testRemoveById_nonEmptyObject_removeFirstIndex() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        OurArrayList list = new OurArrayList();
        list.append(first);
        list.append(second);
        list.append(third);
        assertEquals(first, list.removeById(0));
        assertEquals(second, list.get(1));
        assertEquals(third, list.get(0));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_removeMiddleIndex() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        OurArrayList list = new OurArrayList();
        list.append(first);
        list.append(second);
        list.append(third);
        assertEquals(second, list.removeById(1));
        assertEquals(first, list.get(0));
        assertEquals(third, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_removeLastIndex() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        OurArrayList list = new OurArrayList();
        list.append(first);
        list.append(second);
        list.append(third);
        assertEquals(third, list.removeById(2));
        assertEquals(first, list.get(0));
        assertEquals(second, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemove_nonEmptyObject_removeFirstIndex() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        OurArrayList list = new OurArrayList();
        list.append(first);
        list.append(second);
        list.append(third);
        assertTrue(list.remove(first));
        assertEquals(second, list.get(1));
        assertEquals(third, list.get(0));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemove_nonEmptyObject_removeMiddleIndex() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        OurArrayList list = new OurArrayList();
        list.append(first);
        list.append(second);
        list.append(third);
        assertTrue(list.remove(second));
        assertEquals(first, list.get(0));
        assertEquals(third, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemove_nonEmptyObject_removeLastIndex() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        OurArrayList list = new OurArrayList();
        list.append(first);
        list.append(second);
        list.append(third);
        assertTrue(list.remove(third));
        assertEquals(first, list.get(0));
        assertEquals(second, list.get(1));
        assertEquals(2, list.size());
    }
}