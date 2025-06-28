package com.luogu.algorithm1_6;

import java.util.Scanner;

public class P2249 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int cur = in.nextInt();
            if(i == 0)
                System.out.print(getIndex(num, cur));
            else
                System.out.print(" " + getIndex(num, cur));
        }
    }
    public static int getIndex(int[] arr, int num){
        int left = 0;
        int right = arr.length - 1;
        int target = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] < num){
                left = mid + 1;
            }else if(arr[mid] > num){
                right = mid - 1;
            }else {
                //找到了，但是可能不是在序列中第一次出现，继续去左侧区间寻找
                target = mid + 1;
                right = mid - 1;
            }
        }
        return target;
    }
}
