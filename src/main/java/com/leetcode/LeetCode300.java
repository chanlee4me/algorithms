package com.leetcode;

import java.util.Arrays;

public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length]; //以nums[i]结尾的最长递增子序列长度
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < length; i++) {
            //nums[i]结尾的子序列的前一个数可能是[0,i)中的任意一个满足递增关系的数
            //所以要遍历所有可能，使得dp[i]取最大
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr =  new int[]{10,9,2,5,3,7,101,18};
        LeetCode300 leetCode300 = new LeetCode300();
        leetCode300.lengthOfLIS(arr);

    }
}
