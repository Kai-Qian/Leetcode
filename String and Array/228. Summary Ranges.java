/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/
public class Solution {
    //three pointers
    public List<String> summaryRanges(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<String>();
        }
        ArrayList<String> ans = new ArrayList<String>();
        if(nums.length == 1) {
            String tmp = nums[0] + "";
            ans.add(tmp);
            return ans;
        }
        int front = 0;
        int indx1 = 0;
        int indx2 = 1;
        while(indx2 < nums.length) {
            if(nums[indx2] == (nums[indx1] + 1)) {
                if(indx2 == nums.length - 1) {
                    String tmp = nums[front] + "->" + nums[indx2];
                    ans.add(tmp);
                    break;
                } else {
                    indx1++;
                    indx2 = indx1 + 1;
                }
            } else {
                if(indx2 == nums.length - 1) {
                    //把前面的先处理好
                    if(front == indx1) {
                        String tmp = nums[front] + "";
                        ans.add(tmp);
                    } else {
                        String tmp = nums[front] + "->" + nums[indx1];
                        ans.add(tmp);
                    }
                    //处理最后一个的
                    String tmp2 = nums[indx2] + "";
                    ans.add(tmp2);
                    break;
                } else {
                    if(front == indx1) {
                        String tmp = nums[front] + "";
                        ans.add(tmp);
                    } else {
                        String tmp = nums[front] + "->" + nums[indx1];
                        ans.add(tmp);
                    }
                    front = indx2;
                    indx1 = indx2;
                    indx2 = indx1 + 1;
                }
            }
        }
        return ans;
    }
}