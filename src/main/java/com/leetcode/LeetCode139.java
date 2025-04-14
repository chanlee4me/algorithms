package com.leetcode;

import java.util.List;

public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1]; //dp[i]:前i个字符串能否由字典中的单词拼成
        dp[0] = true;//dp[0]表示空字符串，为了递推公式的合理，此处需置位 true
        for (int i = 1; i <= length; i++) {//
            for (int j = 0; j <= i; j++) {//下标 j作为字符串的切割点
                //字符串能否由字典中的单词拼接成取决于以下两部分
                if(wordDict.contains(s.substring(j, i)) && dp[j] == true){
                    dp[i] = true;
                }
            }
        }
        return dp[length];
    }
}
