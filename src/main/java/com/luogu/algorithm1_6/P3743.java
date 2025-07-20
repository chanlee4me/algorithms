package com.luogu.algorithm1_6;

import java.util.Scanner;

public class P3743 {
    static final double EPS = 1e-4;       // 满足 1e-4 相对误差足够
    static int[] a, b;
    static int p;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        p = in.nextInt();

        a = new int[n];
        b = new int[n];
        long sumA = 0, sumB = 0;

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            sumA += a[i];
            sumB += b[i];
        }
        in.close();
        if (p >= sumA) {
            System.out.println(-1);
            return;
        }

        double left = 0;
        double right = (double) sumB / (sumA - p);   // 理论上界

        while (right - left > EPS) {
            double mid = (left + right) * 0.5;
            if (ok(mid)) left = mid;
            else right = mid;
        }
        System.out.printf("%.10f%n", left);          // left≈right
    }

    private static boolean ok(double t) {
        double need = 0;
        for (int i = 0; i < a.length; i++) {
            double lack = a[i] * t - b[i];
            if (lack > 0) {
                need += lack;
                if (need > (double) p * t) return false;  // 剪枝
            }
        }
        return true;
    }
}

