package com.luogu.algorithm1_4;

import java.util.Scanner;

public class P1990 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 0){
            System.out.println(1);
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 2) {
            System.out.println(2);
            return;
        }
        if (n == 3) {
            System.out.println(5);
            return;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        int[] preSum = new int[n + 1];
        preSum[0] = 1;
        preSum[1] = 2;
        preSum[2] = 4;
        preSum[3] = 9;
        for (int i = 4; i <= n; i++) {
            dp[i] = (preSum[i - 1] + preSum[i - 3]) % 10000;
            preSum[i] = (preSum[i - 1] + dp[i]) % 10000;
        }
        System.out.println(dp[n] % 10000);
    }
}
