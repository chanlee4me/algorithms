package com.luogu.algorithm1_4;

import java.math.BigInteger;
import java.util.Scanner;

public class P1255 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n <= 2) {
            System.out.println(n);
            return;
        }
        BigInteger[] dp = new BigInteger[n + 1];
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.TWO;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        System.out.println(dp[n]);
    }
}
