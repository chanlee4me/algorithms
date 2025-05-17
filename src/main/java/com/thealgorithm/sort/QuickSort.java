package com.thealgorithm.sort;

import java.util.Random;

public class QuickSort {
    /**
     * 快速排序思想：
     * 随机选取一个基准，利用双指针不断交换元素位置，将基准移到首位
     * 现在就分为了两部分，然后再对两部分递归执行快速排序
     */
    //快速排序
    public static void quickSort(int[] nums, int low, int high){
        if(low >= high) return;
        int pivotIndex = partition(nums, low, high);
        quickSort(nums, low, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, high);
    }

    /**
     * 分隔：选择一个基准值，小于基准的移到基准左侧、大于基准的移到基准右侧（升序）
     * 返回分隔后的基准位置
     */
    public static int partition(int[] nums, int low, int high){
        //生成[low, high]范围内的随机数
        Random random = new Random();
        int pivotIndex = random.nextInt(high - low + 1) + low;//random.nextInt(n) 方法会生成一个 [0, n - 1]的随机整数
        int pivot = nums[pivotIndex];
        //将基准值移动到首位置
        swap(nums, pivotIndex, low);
        //利用双指针交换元素位置
        int i = low + 1, j = high;
        while(i <= j){
            while(i <= j &&nums[i] < pivot) i++;
            while(j >= i && nums[j] > pivot) j--;
            if(i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        swap(nums, low, j);
        return j;
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}