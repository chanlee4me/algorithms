package com.luogu.algorithm1_5;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class P1080 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n + 1][2];
        for (int i = 0; i < n + 1; i++) {
            arr[i][0] = in.nextInt();//左手
            arr[i][1] = in.nextInt();//右手
        }
        Arrays.sort(arr, 1, arr.length, (a,b)->{
            return Integer.compare(a[0] * a[1], b[0] * b[1]);
        });
        BigInteger leftReward = new BigInteger(String.valueOf(arr[0][0]));
        BigInteger maxReward = BigInteger.ZERO; // 存储最大金币数
        for (int i = 1; i < arr.length - 1; i++) {
            BigInteger reward = leftReward.divide(BigInteger.valueOf(arr[i][1]));
            maxReward = maxReward.max(reward); // 更新最大金币数
            leftReward = leftReward.multiply(BigInteger.valueOf(arr[i][0]));
        }
        System.out.println(maxReward);
    }
}