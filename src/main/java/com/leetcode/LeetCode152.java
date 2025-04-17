package com.leetcode;

public class LeetCode152 {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] dpMax = new int[length];//以 nums[i]结尾的乘积最小的子数组
        int[] dpMin = new int[length];//以 nums[i]结尾的乘积最大的子数组

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            dpMax[i] = nums[i];
            dpMin[i] = nums[i];
            res = Math.max(dpMax[i], res);
        }
        for (int i = 1; i < length; i++) {
            int tempMax = Math.max(dpMin[i - 1] * nums[i], dpMax[i - 1] * nums[i]);
            int tempMin = Math.min(dpMin[i - 1] * nums[i], dpMax[i - 1] * nums[i]);
            dpMax[i] = Math.max(dpMax[i], tempMax);
            dpMin[i] = Math.min(dpMin[i], tempMin);
            res = Math.max(dpMax[i], res);
        }
        return res;
    }
}
