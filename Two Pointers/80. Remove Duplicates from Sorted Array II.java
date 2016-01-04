/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        int first = 0;
        int second = 1;
        int len = nums.length;
        int ans = 0;
        while(first < len && second < len) {
            if(nums[first] != nums[second]) {
               nums[ans] = nums[first];
               first++;
               second++;
               ans = ans + 1;
            } else {
                int tmp = nums[first];
                nums[ans] = tmp;
                ans = ans + 1;
                nums[ans] = tmp;
                ans = ans + 1;
                while(second < len && tmp == nums[second]) {
                    second++;
                }
                first = second;
                second++;
            }
        }
        if(first == len - 1 && second == len) {
            nums[ans] = nums[first];
            ans++;
        }
        return ans;
    }
}