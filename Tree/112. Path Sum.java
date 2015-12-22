/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        int tmp = sum - root.val;
        boolean l = false;
        boolean r = false;
        if( root.left == null && root.right == null && tmp == 0) {
            return true;
        } else if(root.left == null && root.right == null && tmp != 0) {
            return false;
        } else {
            if(root.left != null) {//应该不用这个判断，因为一开始就有root == null的判断
                l = hasPathSum(root.left, tmp);
            }
            if(root.right != null) {//应该不用这个判断，因为一开始就有root == null的判断
                r = hasPathSum(root.right, tmp);
            }
        }
        return (l || r);
    }
}