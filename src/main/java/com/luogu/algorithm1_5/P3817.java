package com.luogu.algorithm1_5;

import java.util.Scanner;

public class P3817 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int count = 0;
        for (int i = 1; i < n; i++) {
            int sum = arr[i] + arr[i - 1];
            if(sum > x){
                int eat = sum - x;
                count += eat;
                if(arr[i] >= eat){
                    arr[i] -= eat;
                }else{
                    eat -= arr[i - 1];
                    arr[i] = 0;
                    arr[i - 1] -= eat;
                }
            }
        }
        System.out.println(Math.max(count, 0));
    }
}
