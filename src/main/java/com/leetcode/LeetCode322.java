package com.leetcode;

import java.util.Arrays;

public class LeetCode322 {
    static final int INF = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int val : coins) {
                if(i - val >= 0 && dp[i - val] != INF)
                    dp[i] = Math.min(dp[i], dp[i - val] + 1);
            }
        }
        return dp[amount] == INF ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int res = new LeetCode322().coinChange(coins, 11);
    }
}
