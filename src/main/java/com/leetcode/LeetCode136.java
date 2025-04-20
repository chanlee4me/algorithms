package com.leetcode;

public class LeetCode136 {
    public int singleNumber(int[] nums) {
        int val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            val ^= nums[i];
        }
        return val;
    }
}
