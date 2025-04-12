package com.leetcode;

public class LeetCode121 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <= 1) return 0;

        int minCost = prices[0];
        int res = 0;
        for (int i = 1; i < len; i++) {
            if(prices[i] < minCost){
                minCost = prices[i];
            }else{
                int curProfit = prices[i] - minCost;
                res = Math.max(res, curProfit);
            }
        }
        return res;
    }
}
