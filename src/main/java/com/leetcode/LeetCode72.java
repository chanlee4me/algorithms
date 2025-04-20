package com.leetcode;

public class LeetCode72 {
    public int minDistance(String word1, String word2) {
        /**
         * 如果当前两个字符相等，那么就取决于前一个
         * 如果不相等，那么就插入/删除/替换
         */
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];//dp[i][j]:s1.substring(0, i)变成s2.substring(0, j)的最小步数
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    //替换
                    int alterStep = dp[i - 1][j - 1] + 1;
                    //删除
                    int deleteStep = dp[i - 1][j] + 1;
                    //插入
                    int insertStep = dp[i][j - 1] + 1;
                    int tempMin = Math.min(alterStep, deleteStep);
                    dp[i][j] = Math.min(tempMin, insertStep);
                }
            }
        }
        return dp[len1][len2];
    }
}
