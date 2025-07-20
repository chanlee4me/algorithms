package com.luogu.algorithm1_6;

import java.util.Scanner;

public class P1163 {
    public static double EPS = 1e-10;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double w_0 = in.nextDouble(); //贷款金额
        double w = in.nextDouble();   //每月分期付款金额
        int m = in.nextInt();   //需要支付的月份数
        double left = 0;
        double right = 3;
        while(right - left > EPS){
            double mid = left + (right - left) / 2;
            double compute_ori_money = w * (1 - Math.pow(1 + mid, -m)) / mid;
            if(compute_ori_money > w_0)
                left = mid;
            else
                right = mid;
        }
        double res = (left + right) / 2;
        System.out.printf("%.1f", res * 100);
    }
}
