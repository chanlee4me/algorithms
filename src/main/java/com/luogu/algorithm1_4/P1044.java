package com.luogu.algorithm1_4;

import java.util.Scanner;

public class P1044 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //dp[i][j]：做 i 次push、j次 pop 操作时的合法操作方案数
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if(dp[i][j] == 0) continue;
                //序列不为空
                if(i < n)
                    dp[i + 1][j] += dp[i][j];
                if(i > j)
                    dp[i][j + 1] += dp[i][j];
            }
        }
        System.out.println(dp[n][n]);
    }

}
