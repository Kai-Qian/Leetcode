/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/
public class Solution {
    //只需要找出最大的差值即可，即 max(prices[j] – prices[i]) ，i < j。一次遍历即可，在遍历的时间用遍历low记录 prices[o....i] 中的最小值，就是当前为止的最低售价，时间复杂度为 O(n)。
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int max = 0;
        int low = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++) {
            if(prices[i] < low) {
                low = prices[i];
            } else if(prices[i] - low > max) {
                max = prices[i] - low;
            }
        }
        return max;
    }
}