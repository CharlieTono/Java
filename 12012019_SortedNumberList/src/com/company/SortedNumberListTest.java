package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortedNumberListTest {

    @Test
    public void testSize_nonEmptyObject_returnsSize() {
        int[] source = {1, 2, 3};
        SortedNumberList ourArray = new SortedNumberList(source);
        assertEquals(source.length, ourArray.size());
    }

    @Test
    public void testSize_emptyObject_returns0() {
        SortedNumberList ourArray = new SortedNumberList();
        assertEquals(0, ourArray.size());
    }

    @Test
    public void testGet_nonEmptyObjectFromSortedArray_getsAllElements() {
        int[] source = {1, 2, 3};
        SortedNumberList ourArray = new SortedNumberList(source);
        for (int i = 0; i < source.length; i++) {
            assertEquals(source[i], ourArray.get(i));
        }
    }

    @Test
    public void testGet_nonEmptyObjectFromNonSortedArray_getsAllElements() {
        int[] source = {3, 2, 1};
        SortedNumberList ourArray = new SortedNumberList(source);
        int[] expected = {1, 2, 3};
        for (int i = 0; i < source.length; i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testAdd_nonEmptyObject_addsElementToMiddle() { //better use two testMethods
        int[] source = {1, 2, 3, 5};
        SortedNumberList ourArray = new SortedNumberList(source);
        ourArray.add(4);
        ourArray.add(2);
        int[] expected = {1, 2, 2, 3, 4, 5};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
        assertEquals(6, ourArray.size());
    }

    @Test
    public void testAdd_emptyObject_addsElementToMiddle() { //better use two testMethods
        SortedNumberList ourArray = new SortedNumberList();
        ourArray.add(2);
        assertEquals(2, ourArray.get(0));
        assertEquals(1, ourArray.size());
    }

    @Test
    public void testAdd_nonEmptyObject_addsElementToEnd() {
        int[] source = {1, 2, 3, 5};
        SortedNumberList ourArray = new SortedNumberList(source);
        ourArray.add(6);
        int[] expected = {1, 2, 3, 5, 6};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
        assertEquals(5, ourArray.size());
    }

    @Test
    public void testAdd_nonEmptyObject_addsElementToBeginning() {
        int[] source = {2, 3, 5};
        SortedNumberList ourArray = new SortedNumberList(source);
        ourArray.add(1);
        int[] expected = {1, 2, 3, 5};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
        assertEquals(4, ourArray.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_removeFirstIndex() {
        int[] source = {1, 2, 3};
        SortedNumberList ourArray = new SortedNumberList(source);
        assertEquals(1, ourArray.removeById(0));
        int[] expected = {2, 3};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
        assertEquals(2, ourArray.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_removeMiddleIndex() {
        int[] source = {1, 2, 3};
        SortedNumberList ourArray = new SortedNumberList(source);
        assertEquals(2, ourArray.removeById(1));
        int[] expected = {1, 3};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
        assertEquals(2, ourArray.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_removeLastIndex() {
        int[] source = {1, 2, 3};
        SortedNumberList ourArray = new SortedNumberList(source);
        assertEquals(3, ourArray.removeById(2));
        int[] expected = {1, 2};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
        assertEquals(2, ourArray.size());
    }

    @Test
    public void testRemove_nonEmptyObject_RemoveFirstIndex() {
        int[] source = {1, 2, 3};
        SortedNumberList ourArray = new SortedNumberList(source);
        assertTrue(ourArray.remove(1));
        int[] expected = {2, 3};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
        assertEquals(2, ourArray.size());
    }

    @Test
    public void testRemove_nonEmptyObject_RemoveMiddleIndex() {
        int[] source = {1, 2, 3};
        SortedNumberList ourArray = new SortedNumberList(source);
        assertTrue(ourArray.remove(2));
        int[] expected = {1, 3};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
        assertEquals(2, ourArray.size());
    }

    @Test
    public void testRemove_nonEmptyObject_RemoveLastIndex() {
        int[] source = {1, 2, 3};
        SortedNumberList ourArray = new SortedNumberList(source);
        assertTrue(ourArray.remove(3));
        int[] expected = {1, 2};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
        assertEquals(2, ourArray.size());
    }

    @Test
    public void testRemoveRepeated_nonEmptyObject_removeAllRepeatedElement() {
        int[] source = {1, 1, 2, 3, 3};
        SortedNumberList ourArray = new SortedNumberList(source);
        ourArray.removeRepeated();
        int[] expected = {1, 2, 3};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
        assertEquals(3, ourArray.size());
    }

    @Test
    public void testIntersection_nonEmptyObject_withoutIntersection() {
        int[] array01 = {1, 2, 3};
        int[] array02 = {0, 4, 5};
        SortedNumberList ourArray1 = new SortedNumberList(array01);
        SortedNumberList ourArray2 = new SortedNumberList(array02);
        SortedNumberList ourArray3 = ourArray1.intersection(ourArray2);
        assertEquals(0, ourArray3.size());
    }

    @Test
    public void testIntersection_nonEmptyObject_withIntersection() {
        int[] array01 = {1, 2, 3};
        int[] array02 = {1, 4, 5};
        SortedNumberList ourArray1 = new SortedNumberList(array01);
        SortedNumberList ourArray2 = new SortedNumberList(array02);
        SortedNumberList ourArray3 = ourArray1.intersection(ourArray2);
        int[] expected = {1};
        for (int i = 0; i < ourArray3.size(); i++) {
            assertEquals(expected[i], ourArray3.get(i));
        }
        assertEquals(1, ourArray3.size());
    }

    @Test
    public void testIntersection_nonEmptyObject_withIntersectionAndDublicatedElements() {
        int[] array02 = {1, 1, 5, 5};
        int[] array01 = {2, 2, 5};
        SortedNumberList ourArray1 = new SortedNumberList(array01);
        SortedNumberList ourArray2 = new SortedNumberList(array02);
        SortedNumberList ourArray3 = ourArray1.intersection(ourArray2);
        int[] expected = {5};
        for (int i = 0; i < ourArray3.size(); i++) {
            assertEquals(expected[i], ourArray3.get(i));
        }
        assertEquals(1, ourArray3.size());
    }

    @Test
    public void testIntersection_emptyObjectAndNonEmptyObject_withIntersection() {
        int[] array01 = {};
        int[] array02 = {1, 2, 5, 5};
        SortedNumberList ourArray1 = new SortedNumberList(array01);
        SortedNumberList ourArray2 = new SortedNumberList(array02);
        SortedNumberList ourArray3 = ourArray1.intersection(ourArray2);
        assertEquals(0, ourArray3.size());
    }

    @Test
    public void testIntersection_nonEmptyObjectAndEmptyObject_withIntersection() {
        int[] array01 = {};
        int[] array02 = {1, 2, 5, 5};
        SortedNumberList ourArray1 = new SortedNumberList(array01);
        SortedNumberList ourArray2 = new SortedNumberList(array02);
        SortedNumberList ourArray3 = ourArray2.intersection(ourArray1);
        assertEquals(0, ourArray3.size());
    }

    @Test
    public void testUnion_emptyObjectAndEmptyObject_yieldsEmptyObject() {
        SortedNumberList ourArray1 = new SortedNumberList();
        SortedNumberList ourArray2 = new SortedNumberList();
        assertEquals(0, ourArray1.union(ourArray2).size());
    }

    @Test
    public void testUnion_emptyObjectAndNonEmptyObject_yieldsAnotherObject() {
        int[] source = new int[]{1, 2, 3};
        SortedNumberList ourArray1 = new SortedNumberList();
        SortedNumberList ourArray2 = new SortedNumberList(source);
        SortedNumberList newArray1 = ourArray1.union(ourArray2);
        for (int i = 0; i < source.length; i++) {
            assertEquals(source[i], newArray1.get(i));
        }
        assertEquals(3, newArray1.size());
    }

    @Test
    public void testUnion_nonEmptyObjectAndEmptyObject_yieldsAnotherObject() {
        int[] source = new int[]{1, 2, 3};
        SortedNumberList ourArray1 = new SortedNumberList();
        SortedNumberList ourArray2 = new SortedNumberList(source);
        SortedNumberList newArray1 = ourArray2.union(ourArray1);
        for (int i = 0; i < source.length; i++) {
            assertEquals(source[i], newArray1.get(i));
        }
        assertEquals(3, newArray1.size());
    }

    @Test
    public void testUnion_nonEmptyObject_withIntersection() {
        int[] array01 = {1, 2, 3};
        int[] array02 = {1, 4, 5};
        SortedNumberList ourArray1 = new SortedNumberList(array01);
        SortedNumberList ourArray2 = new SortedNumberList(array02);
        SortedNumberList ourArray3 = ourArray1.union(ourArray2);
        int[] expected = {1, 2, 3, 4, 5};
        for (int i = 0; i < ourArray3.size(); i++) {
            assertEquals(expected[i], ourArray3.get(i));
        }
        assertEquals(5, ourArray3.size());
    }

    @Test
    public void testUnion_nonEmptyObject_withoutIntersection() {
        int[] array01 = {0, 2, 3};
        int[] array02 = {1, 4, 5};
        SortedNumberList ourArray1 = new SortedNumberList(array01);
        SortedNumberList ourArray2 = new SortedNumberList(array02);
        SortedNumberList ourArray3 = ourArray1.union(ourArray2);
        int[] expected = {0, 1, 2, 3, 4, 5};
        for (int i = 0; i < ourArray3.size(); i++) {
            assertEquals(expected[i], ourArray3.get(i));
        }
        assertEquals(6, ourArray3.size());
    }

    @Test
    public void testContains_nonEmptyObject_containsFirstMiddleLastElements() {
        int[] source = {1, 2, 3};
        SortedNumberList list = new SortedNumberList(source);
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
    }

    @Test
    public void testContains_nonEmptyObject_notContainsFirstMiddleLastElements() {
        int[] source = {1, 2, 3};
        SortedNumberList list = new SortedNumberList(source);
        assertFalse(list.contains(4));
        assertFalse(list.contains(5));
        assertFalse(list.contains(6));
    }

}