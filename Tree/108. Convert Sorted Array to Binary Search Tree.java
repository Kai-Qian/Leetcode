/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        int len  = nums.length;
        int mid  = len / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if(mid == 0) {
            return root;
        }
        int[] left = new int[mid];
        System.arraycopy(nums, 0, left, 0, mid);
        //都可以
        // for(int i = 0; i < mid; i++) {
        //     left[i] = nums[i];
        // }
        root.left = sortedArrayToBST(left);
        if(len - mid - 1 > 0) {
            int[] right = new int[len - mid - 1];
            System.arraycopy(nums, mid + 1, right, 0, len - mid - 1);
            //都可以
            // for(int i = mid + 1; i < len; i++) {
            //     right[i - mid - 1] = nums[i];
            // }
            root.right = sortedArrayToBST(right);
        } else {
            return root;
        }
        return root;
    }
}