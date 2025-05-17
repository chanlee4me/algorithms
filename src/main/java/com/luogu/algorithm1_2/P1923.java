package com.luogu.algorithm1_2;

import java.util.Random;
import java.util.Scanner;

public class P1923 {
    private static final Random RND = new Random();
    private static int k;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        k = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        quickSelect(arr, 0, n - 1);
        System.out.print(arr[k]);
    }

    public static void quickSelect(int[] arr, int lo, int hi){
        if(lo >= hi) return;
        int pivotIndex = partition(arr, lo, hi);
        if(pivotIndex == k){
            System.out.print(arr[k]);
            System.exit(0);
        }
        else if(pivotIndex > k){
            quickSelect(arr, lo, pivotIndex - 1);
        }else{
            quickSelect(arr, pivotIndex + 1, hi);
        }
    }

    public static int partition(int[] arr, int lo, int hi){
//        int pivotIndex = RND.nextInt(hi - lo + 1) + lo;
        int pivotIndex = getMedian(arr, lo, hi, lo + (hi - lo) / 2);
        int pivotValue = arr[pivotIndex];
        swap(arr, lo, pivotIndex);
        int i = lo + 1;
        int j = hi;
        while(i <= j){
            while(i <= j && arr[i] < pivotValue) i++;
            while(i <= j && arr[j] > pivotValue) j--;
            if(i <= j){
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        swap(arr, j, lo);
        return j;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int getMedian(int[] arr, int i, int j, int k){
        int min = arr[i];
        if(arr[j] < min){
            min = arr[j];
        }
        if(arr[k] < min){
            min = arr[k];
        }
        int max = arr[i];
        if(arr[j] > max){
            max = arr[j];
        }
        if(arr[k] > max){
            max = arr[k];
        }
        if(arr[i] != min && arr[i] != max){
            return i;
        }else if(arr[j] != min && arr[j] != max){
            return j;
        }else {
            return k;
        }
    }
}
