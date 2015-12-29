/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/
public class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid;
        int ans = Integer.MAX_VALUE;;
        while(left <= right) {
            mid  = left + (right - left) / 2;
            // On the sorted part.
            if(nums[left] <= nums[right]) {
                return Math.min(nums[left], ans);
            }
            // On the rotated part.
            // num[mid] is on the left rotated part.
            if(nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {// num[mid] is on the right rotated part.
                ans = nums[mid];
                right = mid - 1;
            }
        }
        return ans;
    }
}