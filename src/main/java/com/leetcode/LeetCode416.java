package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode416 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int val : nums){
            sum += val;
        }
        if(sum % 2 != 0) return false;
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];//数组的子集和是否可以为 i
        dp[0] = true;
        //loop  if(dp[i - val]){ dp[i] true]}
        //外层物品还是背包？ 外层背包的话会重复使用元素
        Arrays.sort(nums);
        boolean[] used = new boolean[len];
        for (int i = 0; i < nums.length; i++) {//外层物品
            for (int j = sum; j >= nums[i]; j--) {//内层背包
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}
