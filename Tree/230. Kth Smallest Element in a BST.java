/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
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
    //中序遍历，找到第k个
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[2];
        count[0] = 0;
        count[1] = 0;
        inOrder(root, k, count);
        return count[1];
    }
    public void inOrder(TreeNode root, int k, int[] count) {
        if(root == null) {
            return;
        }
        inOrder(root.left, k, count);
        count[0]++;
        if(count[0] == k) {
            count[1] = root.val;
            return;
        } else if(count[0] > k) {
            return;
        } else {
            inOrder(root.right, k, count);
        }
    }
}


/*
在二叉搜索树种，找到第K个元素。
算法如下：
1、计算左子树元素个数left。
2、 left+1 = K，则根节点即为第K个元素
      left >=k, 则第K个元素在左子树中，
     left +1 <k, 则转换为在右子树中，寻找第K-left-1元素。
*/
/*class Solution {
public:
	int calcTreeSize(TreeNode* root){
		if (root == NULL)
			return 0;
		return 1+calcTreeSize(root->left) + calcTreeSize(root->right);		
	}
	int kthSmallest(TreeNode* root, int k) {
		if (root == NULL)
			return 0;
		int leftSize = calcTreeSize(root->left);
		if (k == leftSize+1){
			return root->val;
		}else if (leftSize >= k){
			return kthSmallest(root->left,k);
		}else{
			return kthSmallest(root->right, k-leftSize-1);
		}
	}
};*/