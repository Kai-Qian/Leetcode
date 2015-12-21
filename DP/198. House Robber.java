/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/
public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] D = new int[nums.length + 1];
        D[0] = 0;
        D[1] = nums[0];
        for(int i = 2; i < nums.length + 1; i++) {
            D[i] = Math.max(D[i - 2] + nums[i - 1], D[i - 1]);
        }
        return D[D.length - 1];
    }
}