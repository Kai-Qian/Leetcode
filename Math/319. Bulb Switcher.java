/*
There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

Example:

Given n = 3. 

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off]. 

So you should return 1, because there is only one bulb is on.
*/
/*
我们知道，每当灯泡会改变状态，也就是 toggle 时，是因为它出现在了某个数的整数倍上。

对于第1个灯泡：1*1，会改变1次状态，即 off -》on

对于第2个灯泡：1*2，2*1，会改变2次状态，即 off -》on -》off

对于第3个灯泡：1*3，3*1，会改变2次状态，即 off -》on -》off

对于第4个灯泡：1*4，2*2，4*1，会改变3次状态，即 off -》on -》off -》on

……

会发现，每当我找到一个数的整数倍，总会找到对称的一个整数倍，例如 1*2，就肯定会有一个 2*1。唯一的例外出现在平方数上，例如 4 = 2*2，只有一次整数倍。

每次作为偶数次整数倍，最终的灯泡都会还原为 off；只有作为奇数次整数倍，最终的灯泡都会 on。
也就是说，最终亮的灯泡数目由小于其的最大平方数确定。代码非常简单：
*/
public class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
        //用bit manipulation做，结果对，但对大的数会超时
    //     if(n == 0) {
    //         return 0;
    //     } else if(n == 1) {
    //         return n;
    //     } else if(n == 2) {
    //         return n - n / 2;
    //     }
    //     int[] ans = new int[n];
    //     for(int i = 0; i < n; i++) {
    //         if(i % 2 == 0) {
    //             ans[i] = 1;
    //         } else {
    //             ans[i] = 0;
    //         }
    //     }
    //     for(int i = 3; i <= n; i++) {
    //         int k = 1;
    //         while((i * k - 1) < n) {
    //             ans[i * k - 1] = ans[i * k - 1] ^ 1;
    //             k++;
    //         }
    //     }
    //     int count = 0;
    //     for(int i = 0; i < n; i++) {
    //         if(ans[i] == 1) {
    //             count++;
    //         }
    //     }
    //     return count;
    // }
}