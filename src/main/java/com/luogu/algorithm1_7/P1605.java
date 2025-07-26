package com.luogu.algorithm1_7;

import java.util.Scanner;

public class P1605 {
    public static long res = 0;
    public static int[][] map;
    public static int n;
    public static int m;
    public static int t;
    public static int fx;
    public static int fy;
    public static boolean[][] visited;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 迷宫的长
        n = in.nextInt();
        // 迷宫的宽
        m = in.nextInt();
        // 障碍总数
        t = in.nextInt();
        // 起点坐标
        int sx = in.nextInt();
        int sy = in.nextInt();
        //终点坐标
        fx = in.nextInt();
        fy = in.nextInt();

        //地图
        map = new int[n + 1][m + 1];
        for (int i = 0; i < t; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            // -1标识障碍物
            map[x][y] = -1;
        }

        // 标识是否被访问过
        visited = new boolean[n + 1][m + 1];

        // dfs
        visited[sx][sy] = true;
        dfs(sx, sy);

        // output
        System.out.println(res);
    }

    public static void dfs(int x, int y){
        if(x == fx && fy == y){
            res++;
            return;
        }
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] dir : dirs){
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(nx >= 1 && nx <= m && ny >= 1 && ny <= n && map[nx][ny] != -1 && !visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx, ny);
                visited[nx][ny] = false;
            }
        }
    }
}
