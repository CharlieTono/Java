package com.company.collection;

import com.company.comparator.IntComparator;
import com.company.comparator.OurComparator;
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
        int[] source = {2, 5, 1};
        OurLinkedList list = new OurLinkedList();

        for (int i : source) {
            list.append(i);
        }
        assertEquals(3, list.size());
    }

    @Test
    public void testGet_nonEmptyObject_getsAllElements() {
        int[] source = {2, 5, 1};
        OurLinkedList list = new OurLinkedList();

        for (int i : source) {
            list.append(i);
        }

        int[] expected = {2, 5, 1};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_nonEmptyObject_throwsIndexOutOfBoundsException() {
        int[] source = {2, 5, 1};
        OurLinkedList list = new OurLinkedList();

        for (int i : source) {
            list.append(i);
        }

        list.get(-1);

    }

    @Test
    public void testSet_nonEmptyObject_setsFirstElement() {
        int[] source = {1, 4, 2};
        OurLinkedList list = new OurLinkedList();

        for (int i : source) {
            list.append(i);
        }

        list.set(5, 0);
        assertEquals(5, list.get(0));
    }

    @Test
    public void testSet_nonEmptyObject_setsMiddleElement() {
        int[] source = {1, 4, 2};
        OurLinkedList list = new OurLinkedList();

        for (int i : source) {
            list.append(i);
        }

        list.set(5, 1);
        assertEquals(5, list.get(1));
    }

    @Test
    public void testSet_nonEmptyObject_setsLastElement() {
        int[] source = {1, 4, 2};
        OurLinkedList list = new OurLinkedList();

        for (int i : source) {
            list.append(i);
        }

        list.set(5, 2);
        assertEquals(5, list.get(2));
    }

    @Test
    public void testRemoveById_nonEmptyObject_removeFirstIndex() {
        int[] source = {1, 4, 2};
        OurLinkedList list = new OurLinkedList();

        for (int i : source) {
            list.append(i);
        }

        Object deleted = list.removeById(0);
        assertEquals(1, deleted);

        int[] expected = {4, 2};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_removeMiddleIndex() {
        int[] source = {1, 4, 2};
        OurLinkedList list = new OurLinkedList();

        for (int i : source) {
            list.append(i);
        }

        Object deleted = list.removeById(1);
        assertEquals(4, deleted);

        int[] expected = {1, 2};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_removeLastIndex() {
        int[] source = {1, 4, 2};
        OurLinkedList list = new OurLinkedList();

        for (int i : source) {
            list.append(i);
        }

        Object deleted = list.removeById(2);
        assertEquals(2, deleted);

        int[] expected = {1, 4};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(2, list.size());
    }

    @Test
    public void testRemove_nonEmptyObject_removeFirstIndex() {
        int[] source = {2, 9, 1};

        OurLinkedList list = new OurLinkedList();
        for (int i : source) {
            list.append(i);
        }
        assertTrue(list.remove(2));

        int[] expected = {9, 1};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(2, list.size());
    }

    @Test
    public void testRemove_nonEmptyObject_removeMiddleIndex() {
        int[] source = {2, 9, 1};

        OurLinkedList list = new OurLinkedList();
        for (int i : source) {
            list.append(i);
        }
        assertTrue(list.remove(9));

        int[] expected = {2, 1};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(2, list.size());
    }

    @Test
    public void testRemove_nonEmptyObject_removeLastIndex() {
        int[] source = {2, 9, 1};

        OurLinkedList list = new OurLinkedList();
        for (int i : source) {
            list.append(i);
        }
        assertTrue(list.remove(1));

        int[] expected = {2, 9};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(2, list.size());
    }

    @Test
    public void testRemove_emptyObject_notContains() {

        OurLinkedList list = new OurLinkedList();

        assertFalse(list.remove(9));

        assertEquals(0, list.size());
    }

    @Test
    public void testContains_nonEmptyObject_findFirstIndex() {
        int[] source = {2, 9, 1};

        OurLinkedList list = new OurLinkedList();
        for (int i : source) {
            list.append(i);
        }
        assertTrue(list.contains(2));

        int[] expected = {2, 9, 1};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(3, list.size());
    }

    @Test
    public void testContains_nonEmptyObject_findMiddleIndex() {
        int[] source = {2, 9, 1};

        OurLinkedList list = new OurLinkedList();
        for (int i : source) {
            list.append(i);
        }
        assertTrue(list.contains(9));

        int[] expected = {2, 9, 1};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(3, list.size());
    }

    @Test
    public void testContains_nonEmptyObject_findLastIndex() {
        int[] source = {2, 9, 1};

        OurLinkedList list = new OurLinkedList();
        for (int i : source) {
            list.append(i);
        }
        assertTrue(list.contains(1));

        int[] expected = {2, 9, 1};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(3, list.size());
    }

    @Test
    public void testMax_nonEmptyIntegerList_findsMaxInteger() {
        int[] source = {2, 9, 1};

        OurLinkedList list = new OurLinkedList();
        for (int i : source) {
            list.append(i);
        }
        OurComparator intComparator = new IntComparator();
        assertEquals(9, list.max(intComparator));
    }

    @Test
    public void testMin_nonEmptyIntegerList_findsMaxInteger() {
        int[] source = {2, 9, 1};

        OurLinkedList list = new OurLinkedList();
        for (int i : source) {
            list.append(i);
        }
        OurComparator intComparator = new IntComparator();
        assertEquals(1, list.min(intComparator));
    }

    @Test
    public void testSort_nonEmptyIntegerListUnsorted_sortedList() {
        int[] source = {2, 9, 1};

        OurLinkedList list = new OurLinkedList();
        for (int i : source) {
            list.append(i);
        }

        OurComparator intComparator = new IntComparator();
        list.sort(intComparator);

        int[] expected = {1, 2, 9};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(3, list.size());
    }

}