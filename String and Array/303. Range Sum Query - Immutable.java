/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/
public class NumArray {

    private int[] nums;
    public NumArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            this.nums = new int[0];
        } else {
            this.nums = new int[nums.length];
            this.nums[0] = nums[0];
            for(int i = 1; i < nums.length; i++) {
                this.nums[i] = this.nums[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0) {
            return nums[j];
        } else {
            return nums[j] - nums[i - 1];
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);