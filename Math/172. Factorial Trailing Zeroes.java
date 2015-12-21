/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

首先分析N！末尾的0，只有2*5的情况下才会出现。所以对N!进行素数分解：N！=2^i****5^j***.
则末尾0的个数为min(i,j). 又由于i明显远大于j，所以我们只要求解j即可。

又j均由1-N中5的倍数所提供，如果该数仅为5的倍数则贡献1，若为25的倍数则贡献2.
而1-N中，5的倍数个数为|_N/5_|，|_ _|表示取下整数。
又1-N中，25的倍数个数为|_N/25_|.需要注意到的是|_N/5_|已经包含了|_N/25_|。又25的倍数贡献了2，所以考虑到避免重复计算，则N!的素数分解中5的指数j为：
j = |_N/5_|+|_N/25_|+|_N/5^3_|+...
*/
public class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        while(n > 0) {
            ans = ans + n / 5;
            n = n / 5;
        }
        return ans;
    }
}