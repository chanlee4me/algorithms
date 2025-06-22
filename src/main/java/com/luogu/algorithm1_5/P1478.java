package com.luogu.algorithm1_5;

import java.util.Arrays;
import java.util.Scanner;

public class P1478 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();//剩余力气
        int a = in.nextInt();//椅子高度
        int b = in.nextInt();//手能伸到的最长长度
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        Arrays.sort(arr, (m,z)->{
            if(m[1] != z[1])
                return Integer.compare(m[1], z[1]);
            else
                return Integer.compare(m[0], z[0]);
        });
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(s >= arr[i][1] && a + b >= arr[i][0]){
                s -= arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
