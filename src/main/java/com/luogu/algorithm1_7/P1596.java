package com.luogu.algorithm1_7;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class P1596 {
    public static int[][] DIRS = new int[][]{{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
    public static boolean[][] visited;
    public static int rows, cols;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        char[][] ground = new char[n][m];
        visited = new boolean[n][m];
        rows = n;
        cols = m;
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            ground[i] = s.toCharArray();
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j]) continue;
                if(ground[i][j] == 'W'){
                    res++;
                    dfs(ground, i, j);
                }
            }
        }
        System.out.println(res);
    }
    public static void dfs(char[][] ground, int row, int col){
        if(row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || ground[row][col] == '.') return;

        visited[row][col] = true;

        // 将周围相邻的几个水塘置为'A'，然后不断去 DFS
        Deque<int[]> queue = new LinkedList<>();
        for(int[] dir : DIRS){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(ground, newRow, newCol);
        }
    }
}
