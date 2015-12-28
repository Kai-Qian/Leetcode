/*
o(n)的算法只能是线性扫描一遍，可能的相法是位运算。对于异或来说：

1. 异或运算是可交换，即 a ^ b = b ^ a

2. 0 ^ a = a

那么如果对所有元素做异或运算，其结果为那个出现一次的元素，理解是a1 ^ a2 ^ ....，可以将所有相同元素交换至相邻位置，首先运算相同元素，则会产生(n - 1)/2个0异或积，剩余一个单一元素，他们的异或积为这个单一元素自己，得解。
*/
public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int ans = nums[0];
        for(int i = 1;i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
    // public int singleNumber(int[] nums) {
    //     if(nums == null || nums.length == 0) {
    //         return 0;
    //     }
    //     HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
    //     for(int i = 0;i < nums.length; i++) {
    //         if(!hs.containsKey(nums[i])) {
    //             hs.put(nums[i], 1);
    //         } else {
    //             hs.put(nums[i], 2);
    //         }
    //     }
    //     for(Map.Entry<Integer, Integer> entry : hs.entrySet()) {
    //         if(entry.getValue() == 1) {
    //             return entry.getKey();
    //         }
    //     }
    //     return 0;
    // }
}