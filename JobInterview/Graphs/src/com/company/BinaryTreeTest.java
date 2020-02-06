package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    BinaryTree ourBinaryTree = new BinaryTree();

    @Test
    public void testGetVertexTotalNumber_OneNode_OneVertex() {

        BinaryNode root = new BinaryNode(null, null);
        assertEquals(1, ourBinaryTree.getVertexTotalNumber(root));

    }

    @Test
    public void testGetVertexTotalNumber_SevenNodes_SevenVertexes() {

        BinaryNode root01 = new BinaryNode(null, null);
        BinaryNode root02 = new BinaryNode(null, null);
        BinaryNode root03 = new BinaryNode(null, null);
        BinaryNode root04 = new BinaryNode(null, null);

        BinaryNode root05 = new BinaryNode(root01, root02);
        BinaryNode root06 = new BinaryNode(root03, root04);
        BinaryNode root07 = new BinaryNode(root05, root06);

        assertEquals(7, ourBinaryTree.getVertexTotalNumber(root07));

    }

    @Test
    public void testGetTreeHeight_OneVertexWithoutChildren_OneLevel () {
        BinaryNode root04 = new BinaryNode(null, null);
        assertEquals(1, ourBinaryTree.getTreeHeight(root04));
    }

    @Test
    public void testGetTreeHeight_OneVertexesWithChildren_TwoLevels () {
        BinaryNode root01 = new BinaryNode(null, null);
        BinaryNode root02 = new BinaryNode(null, null);

        BinaryNode root05 = new BinaryNode(root01, root02);

        assertEquals(2, ourBinaryTree.getTreeHeight(root05));
    }

}