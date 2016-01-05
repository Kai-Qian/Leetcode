/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/
public class Solution {
    //先用二分查找找出最小数的位置，再分左右进行二分查找
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = left + (right - left) / 2;
        int ans = Integer.MAX_VALUE;
        int indx = 0;
        while(left <= right) {
            // System.out.println(left);
            // System.out.println(right);
            if(nums[left] <= nums[right]) {
                // System.out.println(nums[right]);
                if(nums[left] < ans) {
                    indx = left;
                    break;
                } else {
                    break;
                }
            }
            if(nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                ans = nums[mid];
                indx = mid;
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        // System.out.println("indx--->" + indx);
        ans = bsearch(nums, 0, indx - 1, target);
        if(ans != -1) {
            return ans;
        } else {
            return bsearch(nums, indx, len - 1, target);
        }
    }
    public int bsearch(int[] nums, int left, int right, int key) {
        int mid = left + (right - left) / 2;
        while(left <= right) {
            if(nums[mid] == key) {
                return mid;
            } else if(nums[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        return -1;
    }
}