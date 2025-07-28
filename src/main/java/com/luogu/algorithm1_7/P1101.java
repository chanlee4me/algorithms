package com.luogu.algorithm1_7;

import java.util.*;

public class P1101 {
    static final char[] TARGET = "yizhong".toCharArray();
    // 8个方向：下, 上, 右, 左, 右下, 左上, 右上, 左下
    static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    static int n;
    static char[][] grid;
    static boolean[][] isValidChar; // 用于标记是单词一部分的字符
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        in.nextLine();

        grid = new char[n][n];
        isValidChar = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            // 直接读取一行并转换为字符数组
            grid[i] = in.nextLine().toCharArray();
        }

        // 从'y'开始搜索
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 'y'){
                    for(int d = 0; d < DIRS.length; d++){
                        search(i, j, d);
                    }
                }
            }
        }
        printResult();
    }
    /**
     * 从 (r, c) 开始，沿着固定的方向 dir 搜索 "yizhong"
     * @param r    起始行
     * @param c    起始列
     * @param dir  方向在 DIRS 数组中的索引
     */
    public static void search(int r, int c, int dir){
        // 用于临时记录当前路径上的坐标，如果找到完整单词再标记到 isValidChar
        int[][] path = new int[TARGET.length][2];
        path[0][0] = r;
        path[0][1] = c;

        // 沿着方向查找y之后的字符
        for (int i = 1; i < TARGET.length; i++) {
            int nextR = r + DIRS[dir][0] * i;
            int nextC = c + DIRS[dir][1] * i;

            // 检查边界
            if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) {
                return; // 越界，此方向失败
            }

            // 检查字符是否匹配
            if (grid[nextR][nextC] != TARGET[i]) {
                return; // 字符不匹配，此方向失败
            }

            // 记录路径
            path[i][0] = nextR;
            path[i][1] = nextC;
        }

        // 如果循环正常结束，说明找到了完整的 "yizhong"
        // 将路径上所有字符标记为合法
        for (int i = 0; i < TARGET.length; i++) {
            isValidChar[path[i][0]][path[i][1]] = true;
        }
    }
    /**
     * 根据 isValidChar 矩阵打印最终结果
     */
    public static void printResult() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isValidChar[i][j]) {
                    System.out.print(grid[i][j]);
                } else {
                    System.out.print('*');
                }
            }
            System.out.println(); // 每行结束后换行
        }
    }
}
