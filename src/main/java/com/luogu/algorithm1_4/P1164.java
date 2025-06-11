package com.luogu.algorithm1_4;

import java.util.Arrays;
import java.util.Scanner;

public class P1164 {
    public static void main(String[] args) {
        /**
         * 余额：M元
         * N 种菜，每种菜只有一份
         * 怎么点菜刚好把 M 元花完，有几种花法
         */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] price = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            price[i] = in.nextInt();
        }
        Arrays.sort(price);
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {//菜品
            for (int j = m; j >= 1 && price[i] <= j; j--) {//背包
                dp[j] += dp[j - price[i]];
            }
        }
        System.out.println(dp[m]);
    }
}
