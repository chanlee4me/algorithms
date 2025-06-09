package com.luogu.algorithm1_4;

import javax.xml.validation.SchemaFactoryConfigurationError;
import java.math.BigInteger;
import java.util.Scanner;

public class P2437 {
    public static void main(String[] args) {
        /**
         * 如果 n 为偶数，那么就刚好是个矩形
         * 如果 n 为奇数，那么为矩形再加一个小格子
         */
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        //先创建一个完整的矩形
        int row = 2;
        int col = 0;
        if(n % 2 == 0){//刚好是矩形
            col = n / 2;
        }else{
            col = (n + 1) / 2;
        }
        BigInteger[][] dp = new BigInteger[row][col];
        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < col; c++) {
                dp[r][c] = BigInteger.ZERO;
            }
        }
        for (int i = m; i <= n; i++) {
            //根据索引确定当前格子位置
            int curCol = (i - 1) / 2;
            int curRow = i % 2 == 0 ? 1 : 0;
            if(i == m){
                dp[curRow][curCol] = BigInteger.ONE;
            }
            else if(curRow == 0){
                if(curCol - 1 >= 0)
                    dp[curRow][curCol] = dp[curRow][curCol - 1].add(dp[curRow + 1][curCol - 1]);
                else
                    dp[curRow][curCol] = BigInteger.ZERO;
            }else{
                if(curCol - 1 >= 0)
                    dp[curRow][curCol] = dp[curRow][curCol - 1].add(dp[curRow - 1][curCol]);
                else
                    dp[curRow][curCol] = dp[curRow - 1][curCol];
            }
        }
        int curCol = (n - 1) / 2;
        int curRow = n % 2 == 0 ? 1 : 0;
        System.out.println(dp[curRow][curCol]);
    }
}
