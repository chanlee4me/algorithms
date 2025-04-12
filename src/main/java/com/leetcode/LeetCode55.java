package com.leetcode;

public class LeetCode55 {
    public boolean canJump(int[] nums) {
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            int jumpEdge = nums[i] + i;
            if(jumpEdge > cover) cover = jumpEdge;

            if(cover >= nums.length - 1) return true;
        }
        return false;
    }
}
