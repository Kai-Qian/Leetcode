/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].
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
    //迭代
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // LinkedList<TreeNode> stack = new LinkedList<TreeNode>();//用linkedlist也可以
        stack.push(root);
        TreeNode tmp = root.left;
        TreeNode ptr;
        while(true) {
            while(tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
            if(stack.isEmpty()) {
                break;
            }
            ptr = stack.pop();
            al.add(ptr.val);
            if(ptr.right != null) {
                tmp = ptr.right;
                // stack.push(ptr.right);
            }
        }
        return al;
    }
    //递归
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     ArrayList<Integer> al = new ArrayList<Integer>();
    //     inorder(root, al);
    //     return al;
    // }
    // public void inorder(TreeNode root, ArrayList<Integer> al) {
    //     if(root == null) {
    //         return;
    //     }
    //     inorder(root.left, al);
    //     al.add(root.val);
    //     inorder(root.right, al);
    // }
}