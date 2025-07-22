package com.luogu.algorithm1_7;

import java.util.Scanner;

public class P2392 {
    public static int timeCount = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numArray = new int[4];
        for (int i = 0; i < 4; i++) {
            numArray[i] = in.nextInt();
        }
        int totalTime = 0;
        int[] a_time = new int[numArray[0]];
        for (int i = 0; i < a_time.length; i++) {
            a_time[i] = in.nextInt();
        }
        totalTime += solve(a_time);


        int[] b_time = new int[numArray[1]];
        for (int i = 0; i < b_time.length; i++) {
            b_time[i] = in.nextInt();
        }
        totalTime += solve(b_time);

        int[] c_time = new int[numArray[2]];
        for (int i = 0; i < c_time.length; i++) {
            c_time[i] = in.nextInt();
        }
        totalTime += solve(c_time);

        int[] d_time = new int[numArray[3]];
        for (int i = 0; i < d_time.length; i++) {
            d_time[i] = in.nextInt();
        }
        totalTime += solve(d_time);
        System.out.print(totalTime);

    }
    public static int solve(int[] times){
        int n = times.length;
        int totalTime = 0;
        for (int i = 0; i < n; i++) {
            totalTime += times[i];
        }
        // 目标：找到最接近 totalSum/2 的子集和
        int target = totalTime / 2;

        // dp[i] 表示是否能凑出和为i的子集
        boolean[] dp = new boolean[totalTime / 2 + 1];
        dp[0] = true;

        //对每道题处理
        for (int time :times){
            for (int j = target; j >= time; j--) {
                if (dp[j - time]) {
                    dp[j] = true;
                }
            }
        }

        int maxReachable = 0;
        for (int i = target; i >= 0; i--) {
            if(dp[i]){
                maxReachable = i;
                break;
            }
        }
        return Math.max(maxReachable, totalTime - maxReachable);
    }
}
