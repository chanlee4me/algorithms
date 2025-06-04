package com.luogu.algorithm1_4;

import java.util.Scanner;


class P1002{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(); //row
        int n = in.nextInt(); //col
        int[][] dp = new int[m + 1][n + 1];
        boolean[][] block = new boolean[m + 1][n + 1];
        int horseRow = in.nextInt();
        int horseCol = in.nextInt();
        //把马所在位置标记为 block
        block[horseRow][horseCol] = true;
        //把马能跳跃到的 8 个位置也置为 block
        setBlock(dp, block, horseRow, horseCol);
        if(block[0][0] || block[0][1] || block[1][0]){
            System.out.println(0);
            return;
        }
        dp[0][0] = 1;
        for(int i = 1; i < dp.length; i++){
            if(block[i][0]){
                dp[i][0] = 0;
            }
            else{
                dp[i][0] = dp[i - 1][0];
            }
        }
        for(int i = 1; i < dp[0].length; i++){
            if(block[0][i]){
                dp[0][i] = 0;
            }
            else{
                dp[0][i] = dp[0][i - 1];
            }
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(block[i][j] != true){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        System.out.println(dp[m][n]);
    }
    private static void setBlock(int[][] dp, boolean[][] block, int horseRow, int horseCol){
        if(horseRow - 1 >= 0){
            if(horseCol - 2 >= 0) block[horseRow - 1][horseCol - 2] = true;
            if(horseCol + 2 <= dp[0].length - 1) block[horseRow - 1][horseCol + 2] = true;
        }
        if(horseRow - 2 >= 0){
            if(horseCol - 1 >= 0) block[horseRow - 2][horseCol - 1] = true;
            if(horseCol + 1 <= dp[0].length - 1) block[horseRow - 2][horseCol + 1] = true;
        }
        if(horseRow + 1 < dp.length){
            if(horseCol - 2 >= 0) block[horseRow + 1][horseCol - 2] = true;
            if(horseCol + 2 <= dp[0].length - 1) block[horseRow + 1][horseCol + 2] = true;
        }
        if(horseRow + 2 < dp.length){
            if(horseCol - 1 >= 0) block[horseRow + 2][horseCol - 1] = true;
            if(horseCol + 1 <= dp[0].length - 1) block[horseRow + 2][horseCol + 1] = true;
        }
    }
}