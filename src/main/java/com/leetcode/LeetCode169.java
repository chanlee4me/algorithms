package com.leetcode;

public class LeetCode169 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int count = 0;
        int majorityNum = 0;
        for (int num : nums) {
            if (num == majorityNum) {
                count++;
            } else {
                if (count == 0) {
                    majorityNum = num;
                    count++;
                } else {
                    count--;
                }
            }
        }
        return majorityNum;
    }
}
