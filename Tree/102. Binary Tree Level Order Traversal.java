/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<TreeNode> al = new ArrayList<TreeNode>();
        ArrayList<Integer> al2 = new ArrayList<Integer>();
        al.add(root);
        al2.add(root.val);
        int cur = 0;
        int last = 1;
        while(cur < al.size()) {
            ans.add(al2);
            last = al.size();
            al2 = new ArrayList<Integer>();
            while(cur < last) {
                if(al.get(cur).left != null) {
                    al.add(al.get(cur).left);
                    al2.add(al.get(cur).left.val);
                }
                if(al.get(cur).right != null) {
                    al.add(al.get(cur).right);
                    al2.add(al.get(cur).right.val);
                }
                cur++;
            }
        }
        return ans;
    }
}