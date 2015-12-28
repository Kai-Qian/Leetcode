/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        //网上的O(n)
        int len = nums.length;
        int [] res = new int[len];
        
        if(len < 2) return res;
        
        int [] left = new int[len];
        int [] right = new int[len];
        
        left[0] = 1;
        right[len - 1] = 1;
        for(int i = len - 1; i > 0; i--){
            right[i - 1] = right[i] * nums[i];
        }
        
        for(int i = 0; i < len - 1; i++){
            left[i + 1] = left[i] * nums[i];
        }
        
        for(int i = 0; i < len; i++){
            res[i] = left[i] * right[i];
        }
        return res;
        //自己的O(n)
        // int[] left = new int[nums.length];
        // int[] right = new int[nums.length];
        // left[0] = nums[0];
        // right[nums.length - 1] = nums[nums.length - 1];
        // for(int i = 1; i < nums.length; i++) {
        //     left[i] = left[i - 1] * nums[i];
        // }
        // for(int i = nums.length - 2; i >= 0; i--) {
        //     right[i] = right[i + 1] * nums[i];
        // }
        // int[] ans = new int[nums.length];
        // ans[0] = right[1];
        // ans[nums.length - 1] = left[nums.length - 2];
        // for(int i = 1; i < nums.length - 1; i++) {
        //     ans[i] = left[i - 1] * right[i + 1];
        // }
        // return ans;
        
        //O(1)
        // int len = nums.length;
        // int [] res = new int[len];
        
        // if(len < 2) return res;

        // res[len - 1] = 1;
        // for(int i = len - 1; i > 0; i--){
        //     res[i - 1] = res[i] * nums[i];
        // }
        
        // int left = 1;
        // for(int i = 0; i < len; i++){
        //     res[i] *= left;
        //     left = left * nums[i];
            
        // }
        
        // return res;
    }
}