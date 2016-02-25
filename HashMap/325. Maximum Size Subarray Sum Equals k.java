/*
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
*/
/*
The problem is equal to: find out a range from i to j, in which the sum (nums[i], ..., nums[j]) = k. What is the maximal range? 

So we can first calculate the prefix sum of each number, so sum(i, j) = sum(j) - sum(i - 1) = k. Therefore, for each sum(j), we only need to check if there was a sum(i - 1) which equals to sum(j) - k. We can use a hash map to store the previous calculated sum. 
Note the map.put(0, -1). We need to put this entry into the map before, because if the maximal range starts from 0, we need to calculate sum(j) - sum(i - 1). 
*/
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, -1);
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
            if(hm.containsKey(sum - k)) {
                ans = Math.max(ans, i - hm.get(sum - k));
            }
        }
        return ans;
    }
}