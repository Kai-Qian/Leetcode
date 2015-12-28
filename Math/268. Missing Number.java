/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/
public class Solution {
    //和相减
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int subSum = 0;
        for(int i = 0; i < nums.length; i++) {
            subSum += nums[i];
        }
        return sum - subSum;
    }
//     根据异或的特性，对于一个数，异或自己是0，异或0是自己，所以我们把0-n都异或一遍，再对着给定数组异或一遍，结果就是缺失的数。

// 代码

// 全选复制放进笔记public class Solution {
//     public int missingNumber(int[] nums) {
//         int res = 0;
//         for(int i = 0; i <= nums.length; i++){
//             res ^= i == nums.length ? i : i ^ nums[i];
//         }
//         return res;
//     }
// }
}