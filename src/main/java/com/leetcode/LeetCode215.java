package com.leetcode;

import java.util.Random;

public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        //第length大的元素，下标为 length - length
        //第k大的元素，下标为 length - i
        int length = nums.length;
        int targetIndex = length - k;

        int left = 0, right = length - 1;
        while (true){
            int pivotIndex = partition(nums, left, right);
            if(pivotIndex == targetIndex){
                return nums[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                left = pivotIndex + 1;
            }else{
                right = pivotIndex - 1;
            }
        }
    }
    public int partition(int[]nums, int left, int right){
        Random random = new Random();
        int pivotIndex = random.nextInt(right - left + 1) + left;
        int pivot = nums[pivotIndex];
        swap(nums, left, pivotIndex);
        int i = left + 1, j = right;
        while(i <= j){
            while(i <= j && nums[i] < pivot) i++;
            while(i <= j && nums[j] > pivot) j--;
            if(i > j) break;
            swap(nums, i, j);
            i++; j--;
        }
        swap(nums, left, j);
        return j;
    }
    public void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
