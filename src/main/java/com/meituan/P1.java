package com.meituan;

import java.util.Scanner;

//2024年春招-美团-技术岗-第一批笔试-第一题
public class P1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        char[][] temp = new char[n][n];
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            temp[i] = in.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j] - '0';
            }
        }
        int[][] sum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 2; k <= n; k++) {
                    // 左上角坐标： (i,j)
                    // 右下角坐标：（i + k - 1, j + k - 1）
                    // 区间内 1 的个数
                    if(i + k - 1 > n || j + k - 1 > n) break;
                    int one_count = sum[i + k - 1][j + k - 1] - sum[i - 1][j + k - 1] - sum[i + k - 1][j - 1] + sum[i - 1][j - 1];
                    // 区间内 0 的个数
                    int zero_count = k * k - one_count;
                    if(one_count == zero_count) count[k]++;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(count[i]);
        }
    }
}
