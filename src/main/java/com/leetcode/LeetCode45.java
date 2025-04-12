package com.leetcode;

public class LeetCode45 {
    public int jump(int[] nums) {
        int length = nums.length;
        int cover = 0;
        int maxJumpEdge = 0;
        int curJumpEdge = 0;
        int minJumpCount = 0;

        if(length == 1) return 0;

        for (int i = 0; i <= cover; i++) {
            curJumpEdge = i + nums[i];
            maxJumpEdge = Math.max(curJumpEdge, maxJumpEdge);
            if(i == cover){
                minJumpCount++;
                cover = maxJumpEdge;
                if(cover >= length - 1) break;
            }
        }
        return minJumpCount;
    }
}
