/*
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
*/
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {//把最后一位一个个取出来组成一个新的数字
        int tmp = n;
        int bit = 0;
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            bit = tmp & 1;
            tmp = tmp >>> 1;
            ans = (ans << 1) + bit;
        }
        return ans;
    }
}