package com.leetcode;

public class LeetCode153 {
    public int findMin(int[] nums) {
        //分为两段：段 1、段 2
        //nums[mid] <= nums[length - 1]的话，说明位于段 2，最小值位于他的左侧
        //反之位于他的右侧
        int left = 0, right = nums.length - 1;
        int length = nums.length;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= nums[length - 1]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
