package com.luogu.algorithm1_6;

import java.util.Scanner;

public class P2440 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] length = new int[n];
        long sum = 0;
        int maxLength = 0;
        long res = 0;
        for (int i = 0; i < n; i++) {
            length[i] = in.nextInt();
            sum += length[i];
            maxLength = Math.max(length[i], maxLength);
        }
        if(sum < k) {
            System.out.println(res);
            return;
        }
        int left = 1, right = maxLength;
        while(left <= right){
            int mid = left + (right - left) / 2;
            long count = 0;
            for(int len : length){
                count += len / mid;
                if(count >= k) break;
            }
            if(count >= k){
                left = mid + 1;
                res = Math.max(mid, res);
            }else{
                right = mid - 1;
            }
        }
        System.out.println(res);
    }
}
