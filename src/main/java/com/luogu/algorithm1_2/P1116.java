package com.luogu.algorithm1_2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 将桥转 180，实际上就是互换两个车厢的位置
 * 每互换一次，步数加 1
 * 本题可以抽象为冒泡排序
 */
public class P1116 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int step = bubbleSort(arr);
        System.out.print(step);
    }
    public static int bubbleSort(int[] arr){
        int step = 0;
        int n = arr.length;
        for (int i = 0; i < n; n--) {
            int flag = 0;
            for (int j = i; j < n - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    swap(arr, j + 1, j);
                    flag = 1;
                    step++;
                }
            }
            if(flag == 0) break;
        }
        return step;
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
