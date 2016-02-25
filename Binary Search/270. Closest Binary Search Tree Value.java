、*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
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
    public int closestValue(TreeNode root, double target) {
        int[] ans = new int[1];
        ans[0] = 0;
        double[] tmp = new double[1];
        tmp[0] = Math.abs(target - root.val);
        check(root, target, ans, tmp);
        return ans[0];
    }
    //每次记录一个差值与最优解，每次先比较root.val与target的差值与之前的差值大小，来更新最优解
    public void check(TreeNode root, double target, int[] ans, double[] tmp) {
        if(Math.abs(target - root.val) <= tmp[0]) {
            tmp[0] = Math.abs(target - root.val);
            ans[0] = root.val;
        }
        if(target > root.val) {
            if(root.right != null) {
                check(root.right, target, ans, tmp);
            }
        }
        if(target < root.val) {
            if(root.left != null) {
                check(root.left, target, ans, tmp);
            }
        }
    }
}