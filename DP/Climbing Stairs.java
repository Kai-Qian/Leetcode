/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

public class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n];
        if (n > 2) {
            arr[0] = 1;
            arr[1] = 2;
            for (int i = 2; i < n ; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];//爬到第三阶的方式就是爬到第二阶的方式加上爬到第一阶的方式，因为爬到第二阶了只用再爬一下，爬到第一阶了只用再爬两阶
            }
            return arr[arr.length - 1];
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return -1;
    }
}