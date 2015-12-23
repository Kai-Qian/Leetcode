/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
*/
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //网上的答案
        // Set<Integer> appearedNum = new HashSet<Integer>();
        // int start = 0, end = 0;
        // for(int i = 0; i < nums.length; i++){
        //     if(!appearedNum.contains(nums[i])){
        //         appearedNum.add(nums[i]);
        //         end++;
        //     } else return true;
        //     if(end - start  > k) {
        //         appearedNum.remove(nums[start]);
        //         start++;
        //     }
        // }
        // return false;
        if(nums == null || nums.length == 0) {
            return false;
        }
        boolean ans = false;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(nums.length);//要设置初始化大小，不然rehashing会花很多时间
        for(int i = 0; i < nums.length; i++) {
            if(!hm.containsKey(nums[i])) {
                hm.put(nums[i], i);
            } else {
                int indx = hm.get(nums[i]);
                if(i - indx <= k) {
                    ans = true;
                    break;
                } else {
                    // hm.remove(nums[i]);
                    hm.put(nums[i], i);//要把新的放进去，更新旧的，不然像[1,0,1,1]1这样的就不行了
                }
            }
        }
        return ans;
    }
    //感觉对，但超时
    // public boolean containsNearbyDuplicate(int[] nums, int k) {
    //     if(nums == null || nums.length == 0) {
    //         return false;
    //     }
    //     int indx1 = 0;
    //     int indx2 = 1;
    //     while(indx1 < nums.length - 1){
    //         for(int i = 0; i < k && (i + indx2) < nums.length; i++) {
    //             if(nums[indx1] == nums[indx2 + i]) {
    //                 return true;
    //             }
    //         }
    //         indx1++;
    //         indx2 = indx1 + 1;
    //     }
    //     return false;
    // }
}