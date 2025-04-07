package com.leetcode;

public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int index = -1;
        //用二分法找到目标值
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                index = mid;
                break;
            }
        }
        if(index == -1) return new int[]{-1, -1};
        //找到最左侧的位置
        left = 0; right = index - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
                res[0] = mid;
            }
        }
        //找到最右侧的位置
        left = index + 1; right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                left = mid + 1;
                res[1] = mid;
            }
        }
        if(res[0] == -1) res[0] = index;
        if(res[1] == -1) res[1] = index;
        return res;
    }
}
