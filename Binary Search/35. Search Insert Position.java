/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/
public class Solution {
    //典型的二分查找
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(target < nums[0]) {
            return 0;
        } else if(target > nums[len - 1]) {
            return len;
        }
        int left = 0;
        int right = len - 1;
        int mid;
        while(left < right) {
            mid = left + (right - left) / 2;
            if(nums[mid] > target) {
                right = mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
	/*
	public class Solution {
    //典型的二分查找
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(target < nums[0]) {
            return 0;
        } else if(target > nums[len - 1]) {
            return len;
        }
        int left = 0;
        int right = len - 1;
        int mid;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
*/
}