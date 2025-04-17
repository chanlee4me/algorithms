package com.leetcode;

public class LeetCode32 {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len <= 0) return 0;
        int[] dp = new int[len];//以它结尾的最长合法子串长度
        dp[0] = 0;
        int res = 0;
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if(c == '(') continue;;

            if(dp[i - 1] == 0){
                if(s.charAt(i - 1) == '('){
                    if(i >= 2) dp[i] = dp[i - 2] + 2;
                    else dp[i] = 2;
                }
            }else{
                int index = i - 1 - dp[i - 1];
                if(index >= 0 && s.charAt(index) == '('){
                    dp[i] = dp[i - 1] + 2;
                    index--;
                    if(index >= 0){
                        dp[i] += dp[index];
                    }
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
