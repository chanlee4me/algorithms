package com.huawei;

import java.util.Scanner;

public class P3298 {
    static int m;
    static int n;
    static int[][] height;
    static int[][] maxPath;
    static int[][] DIRS = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    static int res;
    public static void main(String[] args) {
        // 初始化
        init();
        // 选择一个点作为出发点，然后开始搜索
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j);
            }
        }
        System.out.println(res);
    }
    // 起点(x,y)能带来的最长路径和
    public static int dfs(int x, int y){
        if(maxPath[x][y] != 0){
            return maxPath[x][y];
        }
        maxPath[x][y] = 1;
        for(int[] dir : DIRS){
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if(isValid(nextX, nextY, x, y)){
                int temp = dfs(nextX, nextY) + 1;
                maxPath[x][y] = Math.max(maxPath[x][y], temp);
            }
        }
        res = Math.max(maxPath[x][y], res);
        return maxPath[x][y];
    }

    public static boolean isValid(int x, int y, int preX, int preY){
        if(x < 0 || x >= m || y < 0 || y >= n) return false;
        return height[preX][preY] > height[x][y];
    }
    public static void init(){
        Scanner in = new Scanner(System.in);

        m = in.nextInt();
        n = in.nextInt();

        height = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[i][j] = in.nextInt();
            }
        }
        maxPath = new int[m][n];
        res = 0;
    }
}
