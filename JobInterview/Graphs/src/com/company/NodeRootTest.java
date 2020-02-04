package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeRootTest {

    NodeRoot ourNodeRoot = new NodeRoot();

    @Test
    public void testGetVertexTotalNumber_OneNode_OneVertex() {

        Node root = new Node();
        assertEquals(1, ourNodeRoot.getVertexTotalNumber(root));

    }

    @Test
    public void testGetVertexTotalNumber_TreeNodes_TreeVertexes() {

        Node root = new Node();
        root.left = new Node();
        root.right = new Node();
        assertEquals(3, ourNodeRoot.getVertexTotalNumber(root));

    }

    @Test
    public void testGetTreeSize_OneVertexWithoutChildren_OneLevel () {
        Graph root = new Graph();
        Node ourVertex = new Node();
        root.children.add(ourVertex);

        assertEquals(1, ourNodeRoot.getTreeSize(root));

    }

}