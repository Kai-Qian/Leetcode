/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
public class Solution {
    //有点类似矩阵旋转+90度的方法
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int limit = (n - 1) / 2;
        int c = 0;
        if(n % 2 == 0) {
            for(int i = 0; i <= limit; i++) {
                for(int j = i; j < n - 1 - i; j++) {
                    ans[i][j] = ++c;
                    ans[j][n - 1 - i] = ans[i][j] + (n - 2 * i - 1);//(n - 2 * i - 1)是因为每一圈的差值会变化，以2i+1来变
                    ans[n - 1 - i][n - 1 - j] = ans[j][n - 1 - i] + (n - 2 * i - 1);
                    ans[n - 1 - j][i] = ans[n - 1 - i][n - 1 - j] + (n - 2 * i - 1);
                    if(j == n - 2 - i) {
                        c = ans[n - 1 - j][i];
                    }
                }
            }
        } else {
            ans[(n - 1) / 2][(n - 1) / 2] = n * n;
            for(int i = 0; i <= limit; i++) {
                for(int j = i; j < n - 1 - i; j++) {
                    ans[i][j] = ++c;
                    ans[j][n - 1 - i] = ans[i][j] + (n - 2 * i - 1);
                    ans[n - 1 - i][n - 1 - j] = ans[j][n - 1 - i] + (n - 2 * i - 1);
                    ans[n - 1 - j][i] = ans[n - 1 - i][n - 1 - j] + (n - 2 * i - 1);
                    if(j == n - 2 - i) {
                        c = ans[n - 1 - j][i];
                    }
                }
            }
        }
        return ans;
    }
}