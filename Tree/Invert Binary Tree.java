/*
Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
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
    public TreeNode invertTree(TreeNode root) {
        TreeNode left = null;
        TreeNode right = null;
        if (root == null) {
            return null;
        }
        left = invertTree(root.left);
        right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}