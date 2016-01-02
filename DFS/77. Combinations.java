/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
public class Solution {
    //与Combination Sum III一样用回溯法，稍微有一点变形
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        int level = 1;
        dfs(ans, cur, n, k, level);
        return ans;
    }
    public void dfs(ArrayList<List<Integer>> ans, ArrayList<Integer> cur, int n, int k, int level) {
        if(k == 0) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = level; i <= n; i++) {
            cur.add(i);
            dfs(ans, cur, n, k - 1, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}