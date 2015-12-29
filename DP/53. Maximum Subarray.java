/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/
/*
当我们从头到尾遍历这个数组的时候，对于数组里的一个整数，它有几种选择呢？它只有两种选择： 1、加入之前的SubArray；2. 自己另起一个SubArray。那什么时候会出现这两种情况呢？

如果之前SubArray的总体和大于0的话，我们认为其对后续结果是有贡献的。这种情况下我们选择加入之前的SubArray

如果之前SubArray的总体和为0或者小于0的话，我们认为其对后续结果是没有贡献，甚至是有害的（小于0时）。这种情况下我们选择以这个数字开始，另起一个SubArray。
设状态为{f[j]}，表示以{S[j]}结尾的最大连续子序列和，则状态转移方程如下：
f[j]target==max{f[j−1]+S[j],S[j]}, 其中 1≤j≤nmax{f[j]}, 其中 1≤j≤n
解释如下：

\item 情况一，S[j]不独立，与前面的某些数组成一个连续子序列，则最大连续子序列和为$f[j-1]+S[j]$。
\item 情况二，S[j]独立划分成为一段，即连续子序列仅包含一个数S[j]，则最大连续子序列和为$S[j]$。
*/
public class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int f = 0;
        for(int i = 0; i < nums.length; i++) {
            f = Math.max(f + nums[i], nums[i]);
            max = Math.max(f, max);
        }
        return max;
    }
}