package com.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class P3309 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 可以做生意的天数（和商品总数不一定相同）
        int k = in.nextInt();
        // 初始资金
        int m = in.nextInt();

        in.nextLine();

        // 每种商品成本
        String[] costArray = in.nextLine().split(" ");
        // 商品总数
        int length = costArray.length;

        int[] cost = new int[length];
        for (int i = 0; i < length; i++) {
            String s = costArray[i];
            cost[i] = Integer.parseInt(s);
        }

        String[] profitArray = in.nextLine().split(" ");
        // 每种商品利润
        int[] profit = new int[length];
        for (int i = 0; i < length; i++) {
            String s = profitArray[i];
            profit[i] = Integer.parseInt(s);
        }

        in.close();
        // core:每天都买利润最大的商品
        int oriMoney = m;
        int curMoney = oriMoney;
        for (int i = 0; i < k; i++) { // 遍历天数
            // 选择利润最高 且没有被卖的商品
            int goodIndex = -1;
            int maxProfit = -1;
            for (int j = 0; j < length; j++) {   // 遍历商品,找到当前最大利润商品
                if(cost[j] != -1 && curMoney >= cost[j]){   // 当前商品未被购买且资金足够购买该商品
                    if(profit[j] > maxProfit){
                        maxProfit = profit[j];
                        goodIndex = j;
                    }
                }
            }
            // 选择利润最大的商品进行购买
            if(goodIndex < 0 || maxProfit < 0) continue;
            curMoney += maxProfit;
            cost[goodIndex] = -1;
        }

        // output
        System.out.println(curMoney - oriMoney);
    }
}
