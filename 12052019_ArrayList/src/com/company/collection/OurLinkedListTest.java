package com.company.collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class OurLinkedListTest {

    @Test
    public void testSize_emptyObject_returnsSize() {
        OurLinkedList list = new OurLinkedList();
        assertEquals(0, list.size());
    }

    @Test
    public void testSize_nonEmptyObject_returnsSize() {
        Object first = new Object();
        Object second = new Object();
        OurLinkedList list = new OurLinkedList();
        list.append(first);
        list.append(second);
        assertEquals(2, list.size());
    }

    @Test
    public void testGet_nonEmptyObject_getsAllElements() {
        Object first = new Object();
        Object second = new Object();
        OurLinkedList list = new OurLinkedList();
        list.append(first);
        list.append(second);
        assertEquals(first, list.get(0));
        assertEquals(second, list.get(1));
    }

    @Test
    public void testSet_nonEmptyObject_ChangeElementFromTheMiddle() {
        int[] source = {1, 4, 2};
        OurLinkedList list = new OurLinkedList();

        for (int i : source) {
            list.append(i);
        }

        list.set(5, 1);
        assertEquals(5, list.get(1));
    }

    @Test
    public void testSet_nonEmptyObject_setsFirstElement() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        Object newObject = new Object();
        OurLinkedList list = new OurLinkedList();
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
        OurLinkedList list = new OurLinkedList();
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
        OurLinkedList list = new OurLinkedList();
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
        OurLinkedList list = new OurLinkedList();
        list.append(first);
        assertEquals(first, list.get(0));
    }

    @Test
    public void testAppend_fullObject_increasesObjectCapacity() {
        Object first = new Object();
        OurLinkedList list = new OurLinkedList();
        while (list.size() <= 16) {
            list.append(first);
        }
    }

    @Test
    public void testRemoveById_nonEmptyObject_removeElementsFromTheEnd() {
        int[] source = {1, 4, 2};
        OurLinkedList list = new OurLinkedList();

        for (int i : source) {
            list.append(i);
        }

        Object deleted = list.removeById(2);
        assertEquals(null, deleted);

        int[] expected = {1, 4};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
    }

    @Test
    public void testRemoveById_nonEmptyObject_removeFirstIndex() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        OurLinkedList list = new OurLinkedList();
        list.append(first);
        list.append(second);
        list.append(third);
        assertEquals(null, list.removeById(0));
        assertEquals(second, list.get(0));
        assertEquals(third, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_removeMiddleIndex() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        OurLinkedList list = new OurLinkedList();
        list.append(first);
        list.append(second);
        list.append(third);
        assertEquals(null, list.removeById(1));
        assertEquals(first, list.get(0));
        assertEquals(third, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_removeLastIndex() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        OurLinkedList list = new OurLinkedList();
        list.append(first);
        list.append(second);
        list.append(third);
        assertEquals(null, list.removeById(2));
        assertEquals(first, list.get(0));
        assertEquals(second, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemove_nonEmptyObject_removeFirstIndex() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        OurLinkedList list = new OurLinkedList();
        list.append(first);
        list.append(second);
        list.append(third);
        assertTrue(list.remove(first));
        assertEquals(second, list.get(0));
        assertEquals(third, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemove_nonEmptyObject_removeMiddleIndex() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        OurLinkedList list = new OurLinkedList();
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
        OurLinkedList list = new OurLinkedList();
        list.append(first);
        list.append(second);
        list.append(third);
        assertTrue(list.remove(third));
        assertEquals(first, list.get(0));
        assertEquals(second, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testContains_nonEmptyObject_findFirstIndex() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        OurLinkedList list = new OurLinkedList();
        list.append(first);
        list.append(second);
        list.append(third);
        assertTrue(list.contains(first));
        assertEquals(first, list.get(0));
        assertEquals(second, list.get(1));
        assertEquals(third, list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    public void testContains_nonEmptyObject_findMiddleIndex() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        OurLinkedList list = new OurLinkedList();
        list.append(first);
        list.append(second);
        list.append(third);
        assertTrue(list.contains(second));
        assertEquals(first, list.get(0));
        assertEquals(second, list.get(1));
        assertEquals(third, list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    public void testContains_nonEmptyObject_findLastIndex() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        OurLinkedList list = new OurLinkedList();
        list.append(first);
        list.append(second);
        list.append(third);
        assertTrue(list.contains(third));
        assertEquals(first, list.get(0));
        assertEquals(second, list.get(1));
        assertEquals(third, list.get(2));
        assertEquals(3, list.size());
    }
}