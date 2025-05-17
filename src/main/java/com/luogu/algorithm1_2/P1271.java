package com.luogu.algorithm1_2;

import java.util.Random;
import java.util.Scanner;

/**
 * 三路快排特别适合处理数组中有大量重复元素的场景
 * 三路快排的目标是将数组整理为：[小于pivot | 等于pivot | 大于pivot]
 */
public class P1271 {
    private static final Random RND = new Random();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = in.nextInt();
        }
        quickSort(arr, 0, arr.length - 1);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if(i > 0)
                s.append(" ");
            s.append(arr[i]);
        }
        System.out.print(s);
    }
    public static void quickSort(int[] arr, int lo, int hi){
        if(lo >= hi) return;

        int pivotIndex = lo + RND.nextInt(hi - lo + 1);
        swap(arr, lo, pivotIndex);
        int pivotValue = arr[lo];

        //    三路分区 (Dijkstra's partitioning)
        //    目标是将数组分为三部分：
        //    - arr[lo...lt-1]  < pivotValue
        //    - arr[lt...gt]   == pivotValue
        //    - arr[gt+1...hi]  > pivotValue
        int lt = lo;      // 小于 pivotValue 的区间的右边界的下一个位置（也就是说lt是等于pivot的第一个元素的位置）
        int gt = hi;      // 大于 pivotValue 的区间的左边界的上一个位置（gt本身还没有被确认大小）
        int i = lo + 1;

        while(i <= gt){
            if(arr[i] < pivotValue){
                swap(arr, lt, i);
                lt++;
                i++;
            }else if(arr[i] > pivotValue){
                swap(arr, i, gt);
                gt--;
            }else{
                i++;
            }
        }
        quickSort(arr, lo, lt - 1);    // 排序小于枢轴的部分
        quickSort(arr, gt + 1, hi);  // 排序大于枢轴的部分
    }
    public static int partition(int[] arr, int left, int right){
        int pivotIndex = RND.nextInt(right - left + 1) + left;
        int pivot = arr[pivotIndex];
        swap(arr, left, pivotIndex);
        int i = left + 1;
        int j = right;
        while(i <= j){
            while(i <= j && arr[i] <= pivot) i++;
            while(i <= j && arr[j] > pivot) j--;
            if(i <= j){
                swap(arr, i, j);
            }
        }
        swap(arr, j, left);
        return j;
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
