/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        ans[0][0] = grid[0][0];
        for(int i = 1; i < m; i++) {
            ans[i][0] = ans[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < n; i++) {
            ans[0][i] = ans[0][i - 1] + grid[0][i];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                ans[i][j] = Math.min(ans[i - 1][j] + grid[i][j], ans[i][j - 1] + grid[i][j]);//关键，找出到i，j时的最小和
            }
        }
        return ans[m - 1][n - 1];
    }
}