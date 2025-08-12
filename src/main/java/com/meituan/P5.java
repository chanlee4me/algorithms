package com.meituan;

import java.util.Scanner;

public class P5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        in.close();

        // 初始化dp数组为-1（不可达状态）
        long[][] dp = new long[n + 1][10];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0; // 初始状态：0个怪物，击败0只

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (dp[i - 1][j] == -1) continue; // 跳过不可达状态

                // 放生怪物：状态j不变，获得i点经验
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + i);

                // 击败怪物：状态更新为 (j+1)%10
                int newMod = (j + 1) % 10;
                long exp = a[i] + (long) newMod * a[i]; // 基础经验 + 额外经验
                dp[i][newMod] = Math.max(dp[i][newMod], dp[i - 1][j] + exp);
            }
        }

        // 找出所有可能状态的最大值
        long res = 0;
        for (int j = 0; j < 10; j++) {
            res = Math.max(res, dp[n][j]);
        }
        System.out.println(res);
    }
}