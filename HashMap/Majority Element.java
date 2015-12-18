/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!hm.containsKey(nums[i])) {
                hm.put(nums[i], 1);
            } else {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > Math.floor(nums.length / 2)) {
                return entry.getKey();
            }
        }
        return -1;
    }
}