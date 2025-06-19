package com.luogu.algorithm1_5;

import java.util.Arrays;
import java.util.Scanner;

public class P1803 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        Arrays.sort(arr, (a, b)->{
            return Integer.compare(a[1], b[1]);
        });
        int count = 0;
        int preEnd = 0;
        for (int i = 0; i < arr.length; i++) {
            int curStart = arr[i][0];
            int curEnd = arr[i][1];
            if(preEnd <= curStart){
                count++;
                preEnd = curEnd;
            }
        }
        System.out.println(count);
    }
}