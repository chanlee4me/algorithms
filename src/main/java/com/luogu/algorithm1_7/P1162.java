package com.luogu.algorithm1_7;

import java.util.Scanner;

public class P1162 {
    // dp[i][j] 仅经过0的话，能到达边界上的零
    static boolean[][] dp;
    static int[][] matrix;
    static int[][] DIRS = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        dp = new boolean[n][n];
        // init
        for (int i = 0; i < n; i++) {
            if(matrix[i][0] == 0) dp[i][0] = true;
            if(matrix[i][n - 1] == 0) dp[i][n - 1] = true;
            if(matrix[0][i] == 0) dp[0][i] = true;
            if(matrix[n - 1][i] == 0) dp[n - 1][i] = true;
        }
        visited = new boolean[n][n];

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if(!dp[i][j])
                    dfs(i, j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 1)
                    System.out.print(matrix[i][j] + " ");
                else{
                    if(dp[i][j])
                        System.out.print(matrix[i][j] + " ");
                    else
                        System.out.print(2 + " ");
                }
            }
            System.out.println();
        }
    }
    // 能到达边界上的零：返回 true，否则返回 false
    public static boolean dfs(int row, int col){
        int n = matrix.length;
        // 前置检验
        if(!(row >= 0 && row < n && col >= 0 && col < n)) return false;
        if(matrix[row][col] == 1) return false;
        // 到达边界上的 0
        if(matrix[row][col] == 0 && (row == 0 || row == n - 1 || col == 0 || col == n - 1)) return true;
        if(dp[row][col]) return true;

        if(visited[row][col]) return false;

        visited[row][col] = true;
        for(int[] dir : DIRS) {
            int nx = row + dir[0];
            int ny = col + dir[1];
            if(matrix[nx][ny] == 1) continue;
            if(dfs(nx, ny)){
                dp[row][col] = true;
                break;
            }
        }
        visited[row][col] = false;
        return dp[row][col];
    }

}