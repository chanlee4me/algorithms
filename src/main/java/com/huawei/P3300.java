package com.huawei;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class P3300 {
    public static int[][] DIRS = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,-1},{1,1},{-1,1},{-1,-1}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();

        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] temp = in.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int subNetCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1){
                    subNetCount++;
                    dfs(map, i, j);
                }
            }
        }
        // s - 1 + 1
        System.out.println(subNetCount * (subNetCount - 1) / 2);
    }

    public static int func(int i){
        if(i <= 1) return 0;
        return i - 1 + func(i - 1);
    }
    public static void dfs(int[][] map, int row, int col){
        int m = map.length;
        int n = map[0].length;

        if(row < 0 || row >= m || col < 0 || col >= n) return;
        if(map[row][col] != 1) return;
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        map[row][col] = -1;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];
            for(int[] dir : DIRS) {
                int nextRow = x + dir[0];
                int nextCol = y + dir[1];
                if(isValid(map, nextRow, nextCol)){
                    map[nextRow][nextCol] = -1;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }
    }
    public static boolean isValid(int[][] map, int row, int col){
        int m = map.length;
        int n = map[0].length;
        if(row < 0 || row >= m || col < 0 || col >= n) return false;
        if(map[row][col] != 1) return false;
         return true;
    }
}
