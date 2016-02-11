/*
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
//backtracking的典型写法，用个for循环外加list.add和list.remove
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int level = 0;
        backtracking(ans, list, nums, level);
        return ans;
    }
    
    public void backtracking(ArrayList<List<Integer>> ans, ArrayList<Integer> list, int[] nums, int level) {
        ans.add(new ArrayList<Integer>(list));
        for(int i = level; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(ans, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}