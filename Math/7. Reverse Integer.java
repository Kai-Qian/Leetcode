/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/
public class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        long tmp = 0L;
        if(x < 0) {
            tmp = x * -1L;
            isNegative = true;
        } else {
            tmp = x;
        }
        // long tmp = (long)Math.abs(x);不能这样用，因为一旦x为int中最小的整数，一旦转正以后就会越界，因为int最大的是2的31次方减1，最小为-2的31次方
        long ans = 0;
        while(tmp != 0) {
            int digit = (int)(tmp % 10);
            ans = ans * 10L + digit;
            tmp /= 10;
        }
        if(isNegative == true) {
            if(ans * -1 < Integer.MIN_VALUE) {//处理越界的情况
                return 0;
            } else {
                return ((int)ans) * -1;
            }
        } else {
            if(ans > Integer.MAX_VALUE) {//处理越界的情况
                return 0;
            } else {
                return (int)ans;
            }
        }
    }
}