/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<TreeNode> al = new ArrayList<TreeNode>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        al.add(root);
        TreeNode tmp;
        int cur = 0;
        int last = 0;
        while(last < al.size()) {
            last = al.size();
            while(cur < last) {
                tmp = al.get(cur);
                if(cur == last - 1) {
                    ans.add(tmp.val);
                }
                if(tmp.left != null) {
                    al.add(tmp.left);
                }
                if(tmp.right != null) {
                    al.add(tmp.right);
                }
                cur++;
            }
        }
        return ans;
    }
}