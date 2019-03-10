package com.example.doinglab.bst;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Test {

    @org.junit.Test
    public void testTrue() {
        assertTrue(new Solution().isValidBST(new TreeNode(1)));
    }

    @org.junit.Test
    public void testTrue2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node7.left = node3;
        node7.right = node8;
        node3.left = node1;
        node3.right = node5;
        node8.right = node9;

        assertTrue(new Solution().isValidBST(node7));
    }

    @org.junit.Test
    public void testFalse() {
        assertFalse(new Solution().isValidBST(null));
    }

    @org.junit.Test
    public void testFalse2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node7.left = node3;
        node7.right = node8;
        node3.left = node1;
        node3.right = node9;

        assertFalse(new Solution().isValidBST(node7));
    }

}