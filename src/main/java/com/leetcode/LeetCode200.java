package com.leetcode;

public class LeetCode200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '0') continue;
                count++;
                dfs(grid, i, j);
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int row, int col){
        int m = grid.length;
        int n = grid[0].length;
        if(row < 0 || row >= m || col < 0 || col >= n) return;
        //将经过的地方全部置 0，当附近不再有陆地时就返回
        if(grid[row][col] == '0') return;

        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}
