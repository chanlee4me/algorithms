package com.luogu.algorithm1_2;

import java.util.Random;
import java.util.Scanner;

/**
 * 当普通快排不能通过所有测试点时，尝试三路快排
 */
public class P1177 {
    private static final Random RND = new Random();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        quickSort(arr, 0, arr.length - 1);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(i > 0)
                s.append(" ");
            s.append(arr[i]);
        }
        System.out.print(s);
    }
    public static void quickSort(int[] arr, int lo, int hi){
        if(lo >= hi) return;
        int pivotIndex = partition(arr, lo, hi);
        quickSort(arr, lo, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, hi);
    }
    public static int partition(int[] arr, int left, int right){
        int pivotIndex = RND.nextInt(right - left + 1) + left;
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, left);
        int i = left + 1;
        int j = right;
        while(i <= j) {
            while (i <= j && arr[i] <= pivotValue) i++;
            while (j >= i && arr[j] > pivotValue) j--;
            if(i <= j){
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        swap(arr, left, j);
        return j;
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
