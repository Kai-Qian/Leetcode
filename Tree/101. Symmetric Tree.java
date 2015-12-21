/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode left, TreeNode right) {
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else if(left.val != right.val){
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
//     ArrayList<Integer> tree = new ArrayList<Integer>();
//     public boolean isSymmetric(TreeNode root) {
//         midTraverse(root);
//         ArrayList<Integer> tmp = this.getTree();
//         System.out.println(tmp);
//         for (int i = 0; i < (tmp.size() / 2); i++) {
//             if (tmp.get(i) != tmp.get(tmp.size() - i - 1)) {
//                 return false;
//             }
//         }
//         return true;
//     }
//     public ArrayList<Integer> getTree() {
//         return this.tree;
//     }
//     public void midTraverse(TreeNode root) {
//         if(root == null) {
//             // tree.add(0);
//             return;
//         }
//         // if (root.left == null && root.right == null) {
//         //     tree.add(root.val);
//         //     return;
//         // }
//         if(root.left != null) {
//             midTraverse(root.left);
//         }

//         tree.add(root.val);
//         if(root.right != null) {
//             midTraverse(root.right);
//         }
//     }
// }