/*
Given an array of integers, every element appears three times except for one. Find that single one.
（
01000101+
00100001+
00100001+
00100001+
10010011+
10010011+
10010011
）等于31330137。每一位是1的个数。再对每一位取模。
*/
public class Solution {
    public int singleNumber(int[] A) {
        //不通用做法
    //     if(A.length==0) {
    //         return 0;
    //     }
    //     int ones=0, twos=0, threes=0;
    //     for (int i=0;i<A.length;i++){
    //         twos |= ones & A[i];
    //         ones = ones ^ A[i];
    //         threes = ones & twos;
    //         ones = ones & ~threes;
    //         twos = twos & ~threes;
    //     }
    //     return ones;
    // }
    //通用做法，如果是k次就改成对k取模
    //***用数组记录二进制每一位***
        int[] bitnum = new int[32];
        int res = 0;
        for(int i = 0; i < 32; i++){
            for(int j = 0; j < A.length; j++){
                bitnum[i] += (A[j] >> i) & 1;
            }
            res |= (bitnum[i] % 3) << i;//关键步骤，先取模，再移到对应位置上
        }
        return res;
    }
    //我的方法
    // public int singleNumber(int[] nums) {
    //     StringBuilder tmp = new StringBuilder();
    //     int count = 0;
    //     for(int i = 31; i >= 0; i--) {
    //         count = 0;
    //         for(int j = 0; j < nums.length; j++) {
    //             if(((nums[j] >>> i) & 1) == 1) {
    //                 count++;
    //             }
    //         }
    //         count = count % 3;//每一位一计算好就要取模，不要append之后在for一遍取模，因为像12这样不能先append再取模，不然会占两位的
    //         tmp.append(count + "");
    //     }
    //     // System.out.println(tmp.toString());
    //     int ans = 0;
    //     // int t;
    //     int tt;
    //     boolean isNegative = false;
    //     for(int i = 0; i < tmp.length(); i++) {
    //         tt = Integer.parseInt(tmp.charAt(i) + "");
    //         // tt = (t % 3);
    //         if(i == 0 && tt == 1) {
    //             isNegative = true;
    //         } else if(i == 0 && tt == 0) {
    //             isNegative = false;
    //         }
    //         if(isNegative) {//如果是负数的处理方式
    //             if(i == 0) {
    //                 if(tt == 1) {
    //                     ans += -1 * Math.pow(2, 31 - i);//最高位取负，其余位取正相加计算
    //                 }
    //             } else {
    //                 if(tt == 1) {
    //                     ans += Math.pow(2, 31 - i);
    //                 }
    //             }
    //         } else {
    //             if(tt == 1) {
    //                 ans += Math.pow(2, 31 - i);
    //             }
    //         }
    //     }
    //     // System.out.println(tmp.toString());
    //     return ans;
    // }
}