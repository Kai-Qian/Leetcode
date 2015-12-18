/*
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Subscribe to see which companies asked this question

Show Tags

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean left = false;
        boolean right = false;
        if (p == null && q == null) {
            return true;
        } else if ((p != null && q == null) || (p == null && q != null)) {
            return false;
        }
        left = isSameTree(p.left, q.left) && (p.val == q.val);
        right = isSameTree(p.right, q.right) && (p.val == q.val);
        if (left == true && right == true) {
            return true;
        } else {
            return false;
        }
    }
}