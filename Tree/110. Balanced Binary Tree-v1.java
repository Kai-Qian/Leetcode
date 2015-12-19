/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        boolean f1 = false;
        boolean f2 = false;
        boolean f3 = false;
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null) {
            f1 = isBalanced(root.left);
        } else if (root.left == null) {
            f1 = true;
        }
        if (root.right != null) {
            f2 = isBalanced(root.right);
        } else if (root.right == null) {
            f2 = true;
        }
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1) {
            f3 = true && f1 && f2;
        }
        return f3;
    }

    public int maxDepth(TreeNode root) {
        int left = 0;
        int right = 0;
        if (root == null) {
            return 0;
        }
        left = maxDepth(root.left);
        right = maxDepth(root.right);
        if (left > right) {
            return 1 + left;
        } else {
            return 1 +right;
        }
    }
}