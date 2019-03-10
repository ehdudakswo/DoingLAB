package com.example.doinglab.bst;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Solution {

    private Stack<TreeNode> stack = new Stack<>();
    private HashSet<TreeNode> visited = new HashSet<>();
    private List<TreeNode> inorder = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }

        inorder(root);
        return isSortedList();
    }

    private void inorder(TreeNode root) {
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;

            if (left != null && !visited.contains(left)) {
                stack.push(node);
                stack.push(left);
                continue;
            }

            inorder.add(node);
            visited.add(node);

            if (right != null) {
                stack.push(right);
            }
        }
    }

    private boolean isSortedList() {
        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i).val > inorder.get(i + 1).val) {
                return false;
            }
        }

        return true;
    }

}