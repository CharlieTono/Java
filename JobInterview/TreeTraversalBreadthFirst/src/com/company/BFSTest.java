package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BFSTest {

    @Test
    public void testBFS_OneStepFromRootToEndPointBeginningOfArray_1() {
        ArrayList<ArrayList<Integer>> ourList = new ArrayList<>();
        ourList.add(new ArrayList<>(Arrays.asList(1, 2)));
        ourList.add(new ArrayList<>(Arrays.asList(1, 3)));
        ourList.add(new ArrayList<>(Arrays.asList(2, 3)));
        ourList.add(new ArrayList<>(Arrays.asList(3, 4)));

        BFS bfs = new BFS(ourList);

        assertEquals(1, bfs.breadthFirst(1, 2));

    }

    @Test
    public void testBFS_OneStepFromRootToEndPointMiddleOfArray_1() {
        ArrayList<ArrayList<Integer>> ourList = new ArrayList<>();
        ourList.add(new ArrayList<>(Arrays.asList(1, 2)));
        ourList.add(new ArrayList<>(Arrays.asList(1, 3)));
        ourList.add(new ArrayList<>(Arrays.asList(2, 3)));
        ourList.add(new ArrayList<>(Arrays.asList(3, 4)));

        BFS bfs = new BFS(ourList);

        assertEquals(1, bfs.breadthFirst(1, 3));

    }

    @Test
    public void testBFS_OneStepFromRootToEndPointEndOfArray_2() {
        ArrayList<ArrayList<Integer>> ourList = new ArrayList<>();
        ourList.add(new ArrayList<>(Arrays.asList(1, 2)));
        ourList.add(new ArrayList<>(Arrays.asList(1, 3)));
        ourList.add(new ArrayList<>(Arrays.asList(2, 3)));
        ourList.add(new ArrayList<>(Arrays.asList(3, 4)));

        BFS bfs = new BFS(ourList);

        assertEquals(2, bfs.breadthFirst(1, 4));

    }

    @Test
    public void testBFS_OneStepFromMiddleToEndPointEndOfArray_2() {
        ArrayList<ArrayList<Integer>> ourList = new ArrayList<>();
        ourList.add(new ArrayList<>(Arrays.asList(1, 2)));
        ourList.add(new ArrayList<>(Arrays.asList(1, 3)));
        ourList.add(new ArrayList<>(Arrays.asList(2, 3)));
        ourList.add(new ArrayList<>(Arrays.asList(3, 4)));

        BFS bfs = new BFS(ourList);

        assertEquals(2, bfs.breadthFirst(2, 4));

    }


}