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
    public void testAdd_EmptyObject_addsElementToMiddle() { //better use two testMethods
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
    public void testRemoveById_nonEmptyObject_RemoveFirstIndex() {
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
    public void testRemoveById_nonEmptyObject_RemoveMiddleIndex() {
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
    public void testRemoveById_nonEmptyObject_RemoveLastIndex() {
        int[] source = {1, 2, 3};
        SortedNumberList ourArray = new SortedNumberList(source);
        assertEquals(3, ourArray.removeById(2));
        int[] expected = {1, 2};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
        assertEquals(2, ourArray.size());
    }

    @Test  // write 3 methods for each element
    public void testRemove_nonEmptyObject_AllElementsMatchAndNewSize() {
        SortedNumberList ourArray = new SortedNumberList(new int[]{1, 2, 3});
        ourArray.remove(1);
        int[] expected = {2, 3};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemove_nonEmptyObject_returnTrue() {
        SortedNumberList ourArray = new SortedNumberList(new int[]{1, 2, 3});
        assertTrue(ourArray.remove(1));
    }

    @Test
    public void testRemoveRepeated_NonEmptyObject_RemoveAllRepeatedElement() {
        SortedNumberList ourArray = new SortedNumberList(new int[]{1, 1, 2, 3, 3});
        ourArray.removeRepeated();
        int[] expected = {1, 2, 3};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
        assertEquals(3, ourArray.size());
    }

    @Test
    public void testIntersection_NonEmptyObject_AllNewElementsMatch() {
        SortedNumberList ourArray1 = new SortedNumberList(new int[]{1, 2, 3});
        SortedNumberList ourArray2 = new SortedNumberList(new int[]{1, 4, 5});
        SortedNumberList ourArray3 = ourArray1.intersection(ourArray2);
        assertEquals(2, ourArray3.size());
        int[] expected = {1, 1};
        for (int i = 0; i < ourArray3.size(); i++) {
            assertEquals(expected[i], ourArray3.get(i));
        }
    }

    @Test
    public void testUnion_NonEmptyObject_AllNewElementsMatchAndNonEquals() {
        SortedNumberList ourArray1 = new SortedNumberList(new int[]{1, 2, 3});
        SortedNumberList ourArray2 = new SortedNumberList(new int[]{1, 4, 5});
        SortedNumberList ourArray3 = ourArray1.union(ourArray2);
        assertEquals(5, ourArray3.size());
        int[] expected = {1, 2, 3, 4, 5};
        for (int i = 0; i < ourArray3.size(); i++) {
            assertEquals(expected[i], ourArray3.get(i));
        }
    }

}