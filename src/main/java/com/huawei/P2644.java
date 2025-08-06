package com.huawei;

import java.util.Scanner;

public class P2644 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[][] array = new int[m][2];
        for (int i = 0; i < m; i++) {
            array[i][0] = in.nextInt();
            array[i][1] = in.nextInt();
        }

        // dp[i]：以传送阵 i 为起点，到达终点时的最小开销
        int[] dp = new int[m];
        for (int i = m - 1; i >= 0; i--) {
            int jumpCost = array[i][1];
            // 从当前传送阵能直接达到终点
            if(array[i][0] + i >= m){
                dp[i] = jumpCost;
            }else{
            // 从当前传送阵不可以直接达到终点
                int range = array[i][0];
                // 找到最小花费的中转方案
                int minCost = Integer.MAX_VALUE;
                for(int j = 1; j <= range; j++){
                     minCost = Math.min(dp[i + j], minCost);
                }
                dp[i] = jumpCost + minCost;
            }
        }
        System.out.println(dp[0]);
    }
}
