/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
    public int minDepth(TreeNode root) {
        if(root == null) {
           return 0; 
        }
        int min = Integer.MAX_VALUE;
        int cur = 0;
        int ans = dfs(root, cur, min);
        return ans;
    }
    public int dfs(TreeNode root, int cur, int min) {
        int l = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
        cur++;
        if (root.left == null && root.right == null) {
            if(cur < min) {
                min = cur;
            }
            return min;
        }
        // if (root.left == null && root.right == null) {
        //     return 1;
        // }
        
        if(root.left != null) {
            l = dfs(root.left, cur, min);
        }
        if(root.right != null) {
            r = dfs(root.right, cur, min);
        }
        
        return (l > r) ? r : l;
    }
    
    // public int minDepth(TreeNode root) {
    //     int left = 0;
    //     int right = 0;
    //     if (root == null) {
    //         return 0;
    //     }
    //     if (root.left == null && root.right == null) {
    //         return 1;
    //     }
    //     if (root.left != null) {
    //         left = minDepth(root.left);
    //     }
    //     if (root.right != null) {
    //         right = minDepth(root.right);
    //     }
    //     if(root.right == null) {
    //         return 1 + left;
    //     } else if(root.left == null) {
    //         return 1 +right;
    //     } else if(left <= right) {
    //         return 1 + left;
    //     } else if (left > right) {
    //         return 1 +right;
    //     }
    //     return 0;
    // }
}