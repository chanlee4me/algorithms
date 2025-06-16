package com.luogu.algorithm1_5;

import java.lang.runtime.ObjectMethods;
import java.util.Arrays;
import java.util.Scanner;

public class P2240 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        double[][] arr = new double[n][2];//第一维存价值和重量的比值，第二维存重量
        for (int i = 0; i < n; i++) {
            int m = in.nextInt();
            int v = in.nextInt();
            arr[i][0] = (double) v / m;
            arr[i][1] = m;
        }
        Arrays.sort(arr, (a, b)->{
            return Double.compare(b[0], a[0]);//从大到小排序
        });
        double res = 0;
        double remain = t;
        for (int i = 0; i < arr.length && remain > 0; i++) {
            //尽可能多地拿走将当前价值的金子
            if(remain >= arr[i][1]){
                remain -= arr[i][1];
                res += arr[i][0] * arr[i][1];
            }else{
                res += arr[i][0] * remain;
                remain = 0;
            }
        }
        System.out.printf("%.2f", res);
    }
}
