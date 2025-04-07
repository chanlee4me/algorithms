package com.leetcode;

public class LeetCode33 {
    public int search(int[] nums, int target) {
        int minIndex = findMinIndex(nums, target);
        int left = 0, right = nums.length - 1;
        int length = nums.length - 1;
        if(target <= nums[length - 1]) //位于段 2
            left = minIndex;
        else
            right = minIndex - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public int findMinIndex(int[] nums, int target){
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
        return left;
    }
}
