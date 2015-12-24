/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
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
    //这里用string更快，因为return的就是string，不需要转换
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) {
            return new ArrayList<String>();
        }
        ArrayList<String> al = new ArrayList<String>();
        al.add("");
        dfs(root, al);
        return al;
    }
    public void dfs(TreeNode root, ArrayList<String> al) {
        if(root == null) {
            return;
        }
        String tmp = null;
        if(al.get(al.size() - 1).length() != 0) {
            tmp = al.get(al.size() - 1) + "->" + root.val;
            al.set(al.size() - 1, tmp);
        } else {
            tmp = al.get(al.size() - 1) + root.val;
            al.set(al.size() - 1, tmp);
        }
        dfs(root.left, al);
        if(root.right != null) {
            if(root.left != null) {
                al.add(tmp);
            }
            dfs(root.right, al);
        }
        
    }
    // public List<String> binaryTreePaths(TreeNode root) {
    //     if(root == null) {
    //         return new ArrayList<String>();
    //     }
    //     ArrayList<StringBuilder> al = new ArrayList<StringBuilder>();
    //     ArrayList<String> ans = new ArrayList<String>();
    //     StringBuilder path = new StringBuilder("");
    //     al.add(path);
    //     dfs(root, al);
    //     for(StringBuilder s : al) {
    //         ans.add(s.toString());
    //     }
    //     return ans;
    // }
    // public void dfs(TreeNode root, ArrayList<StringBuilder> al) {
    //     if(root == null) {
    //         return;
    //     }
    //     StringBuilder tmp = null;
    //     if(al.get(al.size() - 1).length() != 0) {
    //         tmp = new StringBuilder(al.get(al.size() - 1).append("->" + root.val));
    //     } else {
    //         tmp = new StringBuilder(al.get(al.size() - 1).append("" + root.val));
    //     }
    //     // al.set(al.size() - 1, al.get(al.size() - 1).append("->" + root.val));
    //     // al.get(al.size() - 1).append("->" + root.val);
    //     dfs(root.left, al);
    //     if(root.right != null) {
    //         if(root.left != null) {
    //             al.add(tmp);
    //         }
    //         dfs(root.right, al);
    //     }
        
    // }
}