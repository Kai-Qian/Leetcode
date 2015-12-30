/*
 robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
*/
/*
我们可以把棋盘的左下角看做二维坐标的原点(0,0)，把棋盘的右上角看做二维坐标(M,N)(坐标系的单位长度为小方格的变长)   
用f(i,j)表示移动到坐标f(i,j)的走法总数，其中0=<i,j<=n，设f(m,n)代表从坐标（0,0）到坐标（m,n）的移动方法，则
f(m,n)=f(m-1,n)+f(m,n-1).
于是状态f(i,j)的状态转移方程为：
f(i,j)=f(i-1,j)+f(i,j-1)   if i,j>0
f(i,j)=f(i,j-1)            if i=0
f(i,j)=f(i-1,j)            if j=0
初始情况就为：f(0,0)=0, f(0,1)=1, f(1,0)=1，这个问题可以在时间O(n^2)，空间O(n^2)内求解，非递归解.
*/
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ans = new int[m][n];
        for(int i = 0; i < m; i++) {
            ans[i][0] = 1;
        }
        for(int i = 0; i < n; i++) {
            ans[0][i] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
            }
        }
        return ans[m - 1][n - 1];
    }
    // 回溯法，答案也正确，但更耗时
    // public int uniquePaths(int m, int n) {
    //     int down = 0;
    //     int right = 0;
    //     int[] ans = new int[1];
    //     ans[0] = 0;
    //     backTracking(down, right, m, n, ans);
    //     return ans[0];
        
    // }
    // public void backTracking(int down, int right, int m, int n, int[] ans) {
    //     if(down == m - 1 && right == n - 1) {
    //         ans[0]++;
    //         return;
    //     }
    //     if(down < m - 1) {
    //         backTracking(down + 1, right, m, n, ans);
    //     }
    //     if(right < n - 1) {//right<left表示stack还没空
    //         backTracking(down, right + 1, m, n, ans);
    //     }
    // }
}