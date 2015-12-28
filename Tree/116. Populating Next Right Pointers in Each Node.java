/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
*/
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    //层次遍历
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        ArrayList<TreeLinkNode> al = new ArrayList<TreeLinkNode>();
        al.add(root);
        int cur = 0;
        int last = 1;
        while(cur < al.size()) {
            last = al.size();
            while(cur < last) {
                if(al.get(cur).left != null) {
                    al.add(al.get(cur).left);
                }
                if(al.get(cur).right != null) {
                    al.add(al.get(cur).right);
                }
                if(cur == last - 1) {
                    al.get(cur).next = null;
                } else {
                    al.get(cur).next = al.get(cur + 1);
                }
                cur++;
            }
        }
    }
}