/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
*/
public class Solution {
    public void rotate(int[] nums, int k) {
        //用array自身，时间快，就是想{1，2，3，4，5，6，7}，k=3，则保留{5，6，7},把{1，2，3，4}右移，再把{5,6,7}放到前面去即可
        k = k % nums.length;//对于k大于nums.length的处理
        int[] tmp = new int[k];
        for(int i = nums.length - k; i < nums.length; i++) {
            tmp[i - (nums.length - k)] = nums[i];
        }
        for(int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        for(int i = 0; i < k; i++) {
            nums[i] = tmp[i];
        }
        //用queue，但时间慢
        // Queue<Integer> queue = new LinkedList<Integer>();
        // for(int i = nums.length - 1; i >= 0; i--) {
        //     queue.offer(nums[i]);
        // }
        // for(int i = 0; i < k; i++) {
        //     queue.offer(queue.poll());
        // }
        // for(int i = nums.length - 1; i >= 0 ; i--) {
        //     nums[i] = queue.poll();
        // }
    }
}