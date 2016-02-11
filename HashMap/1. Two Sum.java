/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[2];
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if(hm.containsKey(tmp) && hm.get(tmp) != i) {//注意后面一个判断条件别忘了，因为可能有｛3，2，5，3｝，target=6这种，但同一个位置的数字不能重复使用
                if(i > hm.get(tmp)) {
                    ans[0] = hm.get(tmp) + 1;
                    ans[1] = i + 1;
                } else {
                    ans[1] = hm.get(tmp) + 1;
                    ans[0] = i + 1;
                }
                break;
            }
        }
        return ans;
    }
}