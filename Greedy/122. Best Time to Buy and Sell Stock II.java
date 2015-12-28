/*
贪心法。从前向后遍历数组，只要当天的价格高于前一天的价格，就算入收益。
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int diff;
        for(int i = 1; i < prices.length; i++) {
            diff = prices[i] - prices[i - 1];
            if(diff > 0) {
                max += diff;
            }
        }
        return max;
    }
}