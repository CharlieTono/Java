package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TreeTest {

    Tree ourTree = new Tree();

    @Test
    public void testSize_OneNodeWithTwoChildren_ThreeVertex() {

        Node vertex01 = new Node(0);
        Node vertex02 = new Node(0);
        Node vertex03 = new Node(0);
        vertex01.children = Arrays.asList(vertex02, vertex03);

        ourTree.root = vertex01;

        assertEquals(3, ourTree.size());

    }

    @Test
    public void testHeight_TwoNodesWithOneChildAndThreeChildren_ThreeVertex() {

        Node vertex01 = new Node(0);
        Node vertex02 = new Node(0);
        Node vertex03 = new Node(0);
        Node vertex04 = new Node(0);
        Node vertex05 = new Node(0);
        vertex01.children = Arrays.asList(vertex02);
        vertex03.children = Arrays.asList(vertex01, vertex04, vertex05);

        ourTree.root = vertex03;

        assertEquals(3, ourTree.height());
    }

    @Test
    public void testHeight_OneNodeWithChild_OneVertex() {

        Node vertex01 = new Node(0);
        Node vertex02 = new Node(0);

        vertex01.children = Arrays.asList(vertex02);

        ourTree.root = vertex01;

        assertEquals(2, ourTree.height());
    }

    @Test
    public void testGetTreeWeight_OneNodeWithChild_SumOfTwoNodes() {

        Node vertex01 = new Node(20);
        Node vertex02 = new Node(10);
        vertex01.children = Arrays.asList(vertex02);

        ourTree.root = vertex01;

        assertEquals(30, ourTree.getTreeWeight(vertex01));
    }

    @Test
    public void testGetTreeWeight_OneNodeWithThreeChildren_SumOfFourNodes() {

        Node vertex01 = new Node(20);
        Node vertex02 = new Node(10);
        Node vertex03 = new Node(5);
        Node vertex04 = new Node(0);
        vertex01.children = Arrays.asList(vertex02, vertex03, vertex04);

        ourTree.root = vertex01;

        assertEquals(35, ourTree.getTreeWeight(vertex01));
    }
}