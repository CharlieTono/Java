package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayTest {

    @Test
    public void testSize_nonEmptyObject_3elements() {
        Array ourArray = new Array(new int[]{2, -9, -10});
        assertEquals(3, ourArray.size());
    }

    @Test
    public void testSize_emptyObject_3elements() {
        Array ourArray = new Array();
        assertEquals(0, ourArray.size());
    }

    @Test
    public void testGet_NonEmptyObject_IndexOfElement() {
        Array ourArray = new Array(new int[]{2, 9, 1});
        assertEquals(2, ourArray.get(0));
        assertEquals(9, ourArray.get(1));
        assertEquals(1, ourArray.get(2));
    }

    @Test
    public void testSet_NonEmptyObject_NewValueOfElement() {
        Array ourArray = new Array(new int[]{2, 9, 1});
        ourArray.set(2, 11);
        assertEquals(11, ourArray.get(2));
    }

    @Test
    public void testSet_NonEmptyObject_NewSizeOfArray() {
        Array ourArray = new Array(new int[]{2, 9, 1});
        ourArray.set(2, 11);
        assertEquals(3, ourArray.size());
    }

    @Test
    public void testAppend_NonEmptyObject_AllElementsMatchAndNewSize() {
        Array ourArray = new Array(new int[]{2, 9, 1});
        ourArray.append(5);
        assertEquals(4, ourArray.size());
        int[] expected = {2, 9, 1, 5};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testAppend_EmptyObject_NewElement() {
        Array ourArray = new Array(new int[]{});
        ourArray.append(5);
        assertEquals(1, ourArray.size());
        assertEquals(5, ourArray.get(0));
    }

    @Test
    public void testInsert_NonEmptyObject_NewElement0Index() {
        Array ourArray = new Array(new int[]{2, 9, 1});
        ourArray.insert(0, 11);
        assertEquals(4, ourArray.size());
        int[] expected = {11, 2, 9, 1};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testInsert_NonEmptyObject_NewElementMiddleIndex() {
        Array ourArray = new Array(new int[]{2, 9, 1});
        ourArray.insert(2, 11);
        assertEquals(4, ourArray.size());
        int[] expected = {2, 9, 11, 1};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testInsert_NonEmptyObject_NewElementLastIndex() {
        Array ourArray = new Array(new int[]{2, 9, 1});
        ourArray.insert(3, 11);
        assertEquals(4, ourArray.size());
        int[] expected = {2, 9, 1, 11};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testInsert_EmptyObject_NewElement() {
        Array ourArray = new Array(new int[]{});
        ourArray.insert(0, 11);
        assertEquals(1, ourArray.size());
        assertEquals(11, ourArray.get(0));
    }

    @Test
    public void testRemoveById_NonEmptyObject_RemoveFirstIndex() {
        Array ourArray = new Array(new int[]{2, 9, 1});
        ourArray.removeById(0);
        assertEquals(2, ourArray.size());
        int[] expected = {9, 1};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemoveById_NonEmptyObject_RemoveMiddleIndex() {
        Array ourArray = new Array(new int[]{2, 9, 1});
        ourArray.removeById(1);
        assertEquals(2, ourArray.size());
        int[] expected = {2, 1};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemoveById_NonEmptyObject_RemoveLastIndex() {
        Array ourArray = new Array(new int[]{2, 9, 1});
        ourArray.removeById(2);
        assertEquals(2, ourArray.size());
        int[] expected = {2, 9};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemove_NonEmptyObject_AllElementsMatchAndNewSize() {
        Array ourArray = new Array(new int[]{2, 9, 1});
        ourArray.remove(1);
        assertEquals(2, ourArray.size());
        int[] expected = {2, 9};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemove_NonEmptyObject_TrueRemoveElement() {
        Array ourArray = new Array(new int[]{2, 9, 1});
        assertTrue(ourArray.remove(1));
    }

}