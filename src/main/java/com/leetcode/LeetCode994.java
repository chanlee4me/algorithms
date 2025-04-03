package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode994 {
    public int func(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> queue = new LinkedList<>();
//        int freshCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //找到所有腐烂的橘子
                if(grid[i][j] == 2) queue.addLast(new int[]{i, j});
//                else if (grid[i][j] == 1) freshCount++;
            }
        }
        int timeCount = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            timeCount++;
            for (int i = 0; i < size; i++) {
                int[] pos = queue.removeLast();
                infect(queue, pos, grid);
            }
        }
        return timeCount;
    }
    public void infect(Deque<int[]> queue, int[] pos, int[][] grid){
        int row = pos[0];
        int col = pos[1];
        int m = grid.length;
        int n = grid[0].length;

        if(row - 1 >= 0 && grid[row - 1][col] == 1){
            grid[row - 1][col] = 2;
            queue.addLast(new int[]{row - 1, col});
        }
        if(row + 1 < m && grid[row + 1][col] == 1){
            grid[row + 1][col] = 2;
            queue.addLast(new int[]{row + 1, col});
        }
        if(col - 1 >= 0 && grid[row][col - 1] == 1){
            grid[row][col - 1] = 2;
            queue.addLast(new int[]{row, col - 1});
        }
        if(col + 1 < n && grid[row][col + 1] == 1){
            grid[row][col + 1] = 2;
            queue.addLast(new int[]{row, col + 1});
        }
    }

}
