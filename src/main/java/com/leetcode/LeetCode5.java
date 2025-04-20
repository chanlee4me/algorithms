package com.leetcode;

public class LeetCode5 {
    public String longestPalindrome(String s) {
        /**
         * dp[i][j]：s.substring(i, j + 1)能否构成回文子串
         * if(s[i] == s[j]) dp[i][j] = dp[i+1][j-1])
         */
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        int[] res = new int[2];
//        int maxLength = 0;
//        String maxLengthString = "";
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 2) dp[i][j] = true;
                    else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if(dp[i][j] && res[1] - res[0] < j - i){
                    res[1] = j;
                    res[0] = i;
                }
            }
        }
        return s.substring(res[0], res[1] + 1);
    }
}
