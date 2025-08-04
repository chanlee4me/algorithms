package com.huawei;

import java.util.Scanner;

public class P3292 {
    /**
     *  思路：
     *  对于任意一段末尾元素为a[i]的数组，可能会有以下 3 种情况：
     *  1：当前子数组并未翻转
     *  2：当前子数组翻转了一部分（意味着a[i]处于翻转态）
     *  3：当前子数组已经翻转完毕（意味着至少a[i]不是翻转态）
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        long maxSum = Integer.MIN_VALUE;
        // dp_1[i]：当前未执行反转，且以a[i]结尾的最大子数组和
        long[] dp_1 = new long[n];
        dp_1[0] = a[0];
        // dp_2[i]：当前已执行反转，但未结束，且以a[i]结尾的最大子数组和
        long[] dp_2 = new long[n];
        dp_2[0] = -a[0];
        // dp_2[i]：当前已结束反转，且以a[i]结尾的最大子数组和
        long[] dp_3 = new long[n];
        dp_3[0] = a[0];
        for (int i = 1; i < n; i++){
            dp_1[i] = Math.max(a[i], dp_1[i - 1] + a[i]);

            dp_2[i] = Math.max(dp_1[i - 1] - a[i], dp_2[i - 1] - a[i]);

            dp_3[i] = Math.max(dp_2[i - 1] + a[i], dp_3[i - 1] + a[i]);

            long temp = Math.max(dp_1[i], dp_2[i]);
            long curMax = Math.max(temp, dp_3[i]);
            maxSum = Math.max(curMax, maxSum);
        }
        System.out.println(maxSum);
    }
}
