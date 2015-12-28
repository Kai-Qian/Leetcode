/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/
/*
将数组所有元素都进行异或得到一个不为0的结果，根据这个结果中的不为0的某一位将数组分成两组

将两组中的元素进行异或，如两个数组的异或值都不为0，则得到最后结果

这里我们是需要找到两个只出现一次的元素a，b。
1. 首先我们把所有的数异或，得到的结果其实就是a与b的异或结果。比如10011001
2. 分组的方法是：选取一个是1的位，然后把所有的数分为两组。这两组满足，第一组该位全为1，第二组该位全为0。首先由于a与b在该位异或为1，那么a，b必然被分到了不同的组。另外相同的数必然在同一组。故这样划分后我们回到了最原始的问题。
*/
public class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        int bit = 0;
        int indx = 0;
        int tmp = ans;
        for(int i = 0; i < 32; i++) {
            bit = tmp & 1;
            if(bit == 1) {
                indx = i;
                break;
            } else {
                tmp = tmp >>> 1;
            }
        }
        ArrayList<Integer> al0 = new ArrayList<Integer>();
        ArrayList<Integer> al1 = new ArrayList<Integer>();
        int t;
        int b;
        for(int i = 0 ;i < nums.length; i++) {
            t = nums[i];
            b = (t >>> indx) & 1;
            if(b == 1) {
                al1.add(nums[i]);
            } else {
                al0.add(nums[i]);
            }
        }
        int ans1 = al0.get(0);
        int ans2 = al1.get(0);
        for(int i = 1; i < al0.size(); i++) {
            ans1 = ans1 ^ al0.get(i);
        }
        for(int i = 1; i < al1.size(); i++) {
            ans2 = ans2 ^ al1.get(i);
        }
        int[] finalAns = {ans1, ans2};
        return finalAns;
    }
}