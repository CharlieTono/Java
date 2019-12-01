package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortedNumberListTest {

    @Test
    public void testSize_nonEmptyObject_3elements() {
        SortedNumberList ourArray = new SortedNumberList(new int[]{1, 2, 3});
        assertEquals(3, ourArray.size());
    }

    @Test
    public void testSize_emptyObject_3elements() {
        SortedNumberList ourArray = new SortedNumberList();
        assertEquals(0, ourArray.size());
    }

    @Test
    public void testGet_NonEmptyObject_IndexOfElement() {
        SortedNumberList ourArray = new SortedNumberList(new int[]{1, 2, 3});
        assertEquals(1, ourArray.get(0));
        assertEquals(2, ourArray.get(1));
        assertEquals(3, ourArray.get(2));
    }

    @Test
    public void testAdd_NonEmptyObject_AllElementsMatchAndNewSize() {
        SortedNumberList ourArray = new SortedNumberList(new int[]{1, 2, 3});
        ourArray.add(4);
        assertEquals(4, ourArray.size());
        int[] expected = {1, 2, 3, 4};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testAdd_EmptyObject_NewElement() {
        SortedNumberList ourArray = new SortedNumberList(new int[]{});
        ourArray.add(5);
        assertEquals(1, ourArray.size());
        assertEquals(5, ourArray.get(0));
    }

    @Test
    public void testRemoveById_NonEmptyObject_RemoveFirstIndex() {
        SortedNumberList ourArray = new SortedNumberList(new int[]{1, 2, 3});
        ourArray.removeById(0);
        assertEquals(2, ourArray.size());
        int[] expected = {2, 3};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemoveById_NonEmptyObject_RemoveMiddleIndex() {
        SortedNumberList ourArray = new SortedNumberList(new int[]{1, 2, 3});
        ourArray.removeById(1);
        assertEquals(2, ourArray.size());
        int[] expected = {1, 3};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemoveById_NonEmptyObject_RemoveLastIndex() {
        SortedNumberList ourArray = new SortedNumberList(new int[]{1, 2, 3});
        ourArray.removeById(2);
        assertEquals(2, ourArray.size());
        int[] expected = {1, 2};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemove_NonEmptyObject_AllElementsMatchAndNewSize() {
        SortedNumberList ourArray = new SortedNumberList(new int[]{1, 2, 3});
        ourArray.remove(1);
        assertEquals(2, ourArray.size());
        int[] expected = {2, 3};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemove_NonEmptyObject_TrueRemoveElement() {
        SortedNumberList ourArray = new SortedNumberList(new int[]{1, 2, 3});
        assertTrue(ourArray.remove(1));
    }

    @Test
    public void testRemoveRepeated_NonEmptyObject_RemoveAllRepeatedElement() {
        SortedNumberList ourArray = new SortedNumberList(new int[]{1, 1, 2, 3, 3});
        ourArray.removeRepeated();
        assertEquals(3, ourArray.size());
        int[] expected = {1, 2, 3};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
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