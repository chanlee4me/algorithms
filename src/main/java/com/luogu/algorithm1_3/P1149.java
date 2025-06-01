package com.luogu.algorithm1_3;

import java.util.Scanner;

public class P1149{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        if(n <= 10) {
            System.out.println(res);
            return;
        }
        int[] costArray = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        int flag = 0;//i + i = sum 这种情况只计算一次
        //确定第一个数
        for (int i = 0; getSingleCost(costArray, i) <= n; i++)
            for (int j = 0; ; j++) {//确定第二个数
                if(getSingleCost(costArray, i) + getSingleCost(costArray, j) + 4 >= n) continue;
                //先构造等式
                int sum = i + j;
                //计算消耗
                int cost = getCost(costArray, i, j, sum);
                if (cost == n) {
                    if(i != j) res++;
                    else{
                        if(flag == 0) res++;
                        else flag = 1;
                    }
                }
        }
        System.out.print(res);
    }
    public static int getSingleCost(int[] cost, int a){
        //将a拆分开
        int aCost = 0;
        String aStr = Integer.toString(a);
        for(char c : aStr.toCharArray()){
            aCost += cost[c - '0'];
        }
        return aCost;
    }
    public static int getCost(int[]cost, int a, int b, int sum){
        //将a拆分开
        int aCost = 0;
        String aStr = Integer.toString(a);
        for(char c : aStr.toCharArray()){
            aCost += cost[c - '0'];
        }
        //将b拆分开
        int bCost = 0;
        String bStr = Integer.toString(b);
        for(char c : bStr.toCharArray()){
            bCost += cost[c - '0'];
        }
        //将 sum 拆分开
        int sumCost = 0;
        String sumStr = Integer.toString(sum);
        for(char c : sumStr.toCharArray()){
            sumCost += cost[c - '0'];
        }
        return aCost + bCost + sumCost + 4;
    }
}
