/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].
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
	//用stack做迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // LinkedList<TreeNode> stack = new LinkedList<TreeNode>();//用linkedlist也可以
        stack.push(root);
        TreeNode tmp;
        while(!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.println(tmp.val);
            al.add(tmp.val);
            if(tmp.right != null) {
                stack.push(tmp.right);
            }
            if(tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        return al;
    }
    //递归实现
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     ArrayList<Integer> al = new ArrayList<Integer>();
    //     preorder(root, al);
    //     return al;
    // }
    // public void preorder(TreeNode root, ArrayList<Integer> al) {
    //     if(root == null) {
    //         return;
    //     }
    //     al.add(root.val);
    //     preorder(root.left, al);
    //     preorder(root.right, al);
    // }
}