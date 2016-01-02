/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k > 9 || k < 1) {
            return new ArrayList<List<Integer>>();
        } 
        //因为k个数字不能重复，所以会有这些限制
        int[] min = {1 ,3 ,6 ,10 ,15 ,21 ,28 ,36 ,45};
        int[] max = {9, 17, 24, 30, 35, 39, 42, 44, 45};
        if(n > max[k - 1] || n < min[k - 1]) {
            return new ArrayList<List<Integer>>();
        }
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        int sum = 0;
        int level = 1;
        dfs(ans, cur, k, n, sum, level);
        return ans;
    }
    //这里的dfs写法值得注意，很好
    public void dfs(ArrayList<List<Integer>> ans, ArrayList<Integer> cur, int k, int n, int sum, int level) {
        if(sum == n && k == 0) {
            ans.add(new ArrayList<Integer>(cur));//注意要new一下
            return;
        } else if(sum > n || k < 0) {
            return;
        }
        //因为不像树有左右结点（要写两个dfs递归），所以这里用for循环来遍历各个结点（实际有多个dfs递归）
        for(int i = level; i <= 9; i++) {
            cur.add(i);
            dfs(ans, cur, k - 1, n, sum + i, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k > 9 || k < 1) {
            return new ArrayList<List<Integer>>();
        } 
        //因为k个数字不能重复，所以会有这些限制
        int[] min = {1 ,3 ,6 ,10 ,15 ,21 ,28 ,36 ,45};
        int[] max = {9, 17, 24, 30, 35, 39, 42, 44, 45};
        if(n > max[k - 1] || n < min[k - 1]) {
            return new ArrayList<List<Integer>>();
        }
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        int sum = 0;
        int level = 1;
        dfs(ans, cur, k, n, sum, level);
        return ans;
    }
    //这里的dfs写法值得注意，很好
    public void dfs(ArrayList<List<Integer>> ans, ArrayList<Integer> cur, int k, int n, int sum, int level) {
        if(sum == n && k == 0) {
            ans.add(new ArrayList<Integer>(cur));//注意要new一下
            return;
        } else if(sum > n || k < 0) {
            return;
        }
        for(int i = level; i <= 9; i++) {
            cur.add(i);
            dfs(ans, cur, k - 1, n, sum + i, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}