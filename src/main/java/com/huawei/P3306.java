package com.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class P3306 {
    public static void main(String[] args) {
        // input

        Scanner in = new Scanner(System.in);
        String[] temp = in.nextLine().split(" ");
        
        // 所需的区域覆盖面积
        int areaRequirement = Integer.parseInt(temp[0]);
        // 总预算
        int budget = Integer.parseInt(temp[1]);
        // 接入点数量
        int n = Integer.parseInt(temp[2]);

        //a[i][0]:cost  a[i][1]:coverage
        int[][] item = new int[n][2];

        for (int i = 0; i < n; i++) {
            temp = in.nextLine().split(" ");
            item[i][1] = Integer.parseInt(temp[0]);
            item[i][0] = Integer.parseInt(temp[1]);
        }

        Arrays.sort(item, (a_,b_) ->{
            // 如果成本相同，按照覆盖面积由大到小排序
            if(a_[0] == b_[0]){
                return Integer.compare(b_[1], a_[1]);
            }else{
            // 否则按照成本由小到大排序
                return Integer.compare(a_[0], b_[0]);
            }
        });

        // core
        int[] dp = new int[budget + 1];

        int minBudget = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = budget; j >= 10; j -= 10) {
                if(item[i][0] <= j){
                    dp[j] = Math.max(dp[j], dp[j - item[i][0]] + item[i][1]);
                    if(dp[j] >= areaRequirement){
                        minBudget = Math.min(minBudget, j);
                    }
                }
            }
        }

        if(minBudget != Integer.MAX_VALUE){
            System.out.println(minBudget + " " + dp[minBudget]);
        }else{
            System.out.println(0 + " " + 0);
        }
    }
}
