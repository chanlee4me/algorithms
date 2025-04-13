package com.leetcode;

import java.util.Arrays;

public class LeetCode279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 12;
        int res = new LeetCode279().numSquares(n);
        System.out.println("res = " + res);
    }
}
