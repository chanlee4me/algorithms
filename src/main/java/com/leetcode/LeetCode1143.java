package com.leetcode;

public class LeetCode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        /**
         * dp[i][j]：以text1[i - 1]、text2[j - 1]结尾的字符串的最长公共子序列
         * if(text1[i - 1] == text2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
         * if(
         */
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1][len2];

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }
}
