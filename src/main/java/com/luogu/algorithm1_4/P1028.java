package com.luogu.algorithm1_4;

import java.util.Scanner;

public class P1028 {
    static int count = 0;
    public static int func(int n){
        /**
         * dp[x]：首项是x 的所有合法数列个数
         */
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {//以元素 i 为起始
            for (int j = 1; j <= i / 2; j++) {//不断在 i 后面增加
                dp[i] += dp[j];
            }
            dp[i] += 1;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = func(n);
        System.out.println(res);
    }
}
