package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TreeTest {

    Tree ourTree = new Tree();

    @Test
    public void testSize_OneNodeWithTwoChildren_ThreeVertex() {

        Node vertex01 = new Node();
        Node vertex02 = new Node();
        Node vertex03 = new Node();
        vertex01.children = Arrays.asList(vertex02, vertex03);

        ourTree.root = vertex01;

        assertEquals(3, ourTree.size());

    }

    @Test
    public void testHeight_TwoNodesWithOneChildAndTwoChildren_ThreeVertex() {

        Node vertex01 = new Node();
        Node vertex02 = new Node();
        Node vertex03 = new Node();
        Node vertex04 = new Node();
        Node vertex05 = new Node();
        vertex01.children = Arrays.asList(vertex02);
        vertex03.children = Arrays.asList(vertex04, vertex01);

        ourTree.root = vertex03;

        assertEquals(3, ourTree.height());
    }

    @Test
    public void testHeight_OneNodeWithChild_OneVertex() {

        Node vertex01 = new Node();
        Node vertex02 = new Node();

        vertex01.children = Arrays.asList(vertex02);

        ourTree.root = vertex01;

        assertEquals(2, ourTree.height());
    }
}