/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        if(root == null) {
            return l;
        }
        ArrayList<TreeNode> al = new ArrayList<TreeNode>();
        ArrayList<Integer> al1 = new ArrayList<Integer>();
        
        al.add(root);
        al1.add(root.val);
        l.add(al1);
        int cur = 0;
        int last = 1;
        while(cur < al.size()) {
            last = al.size();
            ArrayList<Integer> al2 = new ArrayList<Integer>();
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
            if(!al2.isEmpty()) {
                l.add(al2);
            }
        }
        Collections.reverse(l);
        return l;
    }
    // 层次遍历
    // public ArrayList<TreeNode> levelTraverse(TreeNode root) {
    //     if(root == null) {
    //         return null;
    //     }
    //     ArrayList<TreeNode> al = new ArrayList<Integer>();
    //     al.add(root);
    //     int cur = 0;
    //     while(cur < al.size()) {
    //         if(al.get(cur).left != null) {
    //             al.add(al.get(cur).left);
    //         }
    //         if(al.get(cur).right != null) {
    //             al.add(al.get(cur).right);
    //         }
    //         cur++;
    //     }
    //     return al;
    // }
}