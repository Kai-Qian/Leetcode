/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/
public class Solution {
	//http://www.felix021.com/blog/read.php?1587
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0) {
            return 0;
        }
        int[] b = new int[len];
        int position;
        int max = 1;
        b[0] = nums[0];
        for(int i = 1; i < len; i++) {
            position = findInsertPosition(b, nums[i], max);
            b[position] = nums[i];
            if(max < position + 1) {
                max = position + 1;
            }
        }
        return max;
    }
    public int findInsertPosition(int[] b, int key, int right) {
        int len = b.length;
        // for(int i = 0; i < right; i++) {
        //     System.out.println("b--->" + i + " " + b[i]);
        // }
        int left = 0;
        //right -= 1;//如果用left<right 以及right = mid就不用right=len - 1
        // int right = len - 1;因为b.length一直都是之前设定的len，所以不能用right = len - 1来做，要传入非0 的元素的长度
        int mid = left + (right - left) / 2;
        while(left < right) {
            if(b[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
            mid = left + (right - left) / 2;
        }
        // System.out.println("left--->" + left);
        return left;
    }
    
    // public int findInsertPosition(int[] b, int key, int right) {
    //     int len = b.length;
    //     // for(int i = 0; i < right; i++) {
    //     //     System.out.println("b--->" + i + " " + b[i]);
    //     // }
    //     int left = 0;
    //     right -= 1;//如果用left<=right 以及right = mid - 1就用right=len - 1
    //     // int right = len - 1;因为b.length一直都是之前设定的len，所以不能用right = len - 1来做，要传入非0 的元素的长度
    //     int mid = left + (right - left) / 2;
    //     while(left <= right) {
    //         if(b[mid] < key) {
    //             left = mid + 1;
    //         } else {
    //             right = mid - 1;
    //         }
    //         mid = left + (right - left) / 2;
    //     }
    //     // System.out.println("left--->" + left);
    //     return left;
    // }
    
    /*
	http://www.360doc.com/content/13/0601/00/8076359_289597587.shtml#
	*/
    // public int lengthOfLIS(int[] nums) {
    //     int len = nums.length;
    //     int[] d = new int[len];
    //     int max = 0;
    //     for(int i = 0; i < len; i++) {
    //         d[i] = 1;
    //         for(int j = 0; j < i; j++) {
    //             if(nums[i] > nums[j] && d[j] + 1 > d[i]) {
    //                 d[i] = d[j] + 1;
    //             }
    //         }
    //         if(d[i] > max) {
    //             max = d[i];
    //         }
    //     }
    //     return max;
    // }
}