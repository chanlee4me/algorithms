package com.luogu.algorithm1_5;

import java.util.Arrays;
import java.util.Scanner;

public class P1208 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//牛奶总量
        int m = in.nextInt();//农民个数
        int cost = 0; // 采购花费
        int[][] milk = new int[m][2];
        for (int i = 0; i < m; i++) {
            milk[i][0] = in.nextInt();//单价
            milk[i][1] = in.nextInt();//产量
        }
        //按单价排序
        Arrays.sort(milk, (a,b)->{
           return Integer.compare(a[0], b[0]);
        });
        //先买最便宜的
        for (int i = 0; i < m; i++) {
            if(n >= milk[i][1]){
                n -= milk[i][1];
                cost += milk[i][0] * milk[i][1];
            }else{
                cost += milk[i][0] * n;
                n = 0;
            }
        }
        System.out.println(cost);
    }
}
