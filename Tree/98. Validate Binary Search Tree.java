/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
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
    //2ms
    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        ArrayList<Integer> al = new ArrayList<Integer>(1);
        al.add(null);//这句别忘了，不然没有初始化
        return inorder(root, al);
    }
    
    public boolean inorder(TreeNode root, ArrayList<Integer> al) {
        if(root == null) {
            return true;
        }
        boolean l = inorder(root.left, al);
        //每次加数字之前就检查，而且实际上不是加，而是更换原来的值，节省空间
        if(al.get(0) != null) {
            if(root.val <= al.get(0)) {
                return false;
            }
        }
        al.set(0, root.val);
        boolean r = inorder(root.right, al);
        return l && r;
    }
    
    //1ms
    // public boolean isValidBST(TreeNode root) {
    //     return isValidBST(root, null, null);
    // }
    //每个左子树的上限都是对应根的val，每个右子树的下限都是对应根的val
    // private boolean isValidBST(TreeNode root, Integer max, Integer min){
    //     if(root == null){
    //         return true;
    //     }
    //     // 如果该节点大于上限 返回假
    //     if(max != null && root.val >= max){
    //         return false;
    //     }
    //     // 如果该节点小于下限 返回假
    //     if(min != null && root.val <= min){
    //         return false;
    //     }
    //     // 递归判断左子树和右子树
    //     return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    // }
    
    //worst
    // public boolean isValidBST(TreeNode root) {
    //     if(root == null || (root.left == null && root.right == null)) {
    //         return true;
    //     }
    //     ArrayList<Integer> al = new ArrayList<Integer>();
    //     inorder(root, al);
    //     for(int i = 0; i < al.size() - 1; i++) {
    //         if(al.get(i) >= al.get(i + 1)) {
    //             return false;
    //         }
    //     }
    //     return true;
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