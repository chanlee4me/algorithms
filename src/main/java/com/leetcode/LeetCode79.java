package com.leetcode;

public class LeetCode79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                boolean res = dfs(board, word, 0, used, row, col);
                if(res == true) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int curIndex, boolean[][] used, int row, int col){
        int m = board.length;
        int n = board[0].length;
        if(curIndex >= word.length()) return true;
        if(row >= m || row < 0 || col >= n || col < 0 || used[row][col] == true) return false;
        if(word.charAt(curIndex) != board[row][col]) return false;
        else{
            used[row][col] = true;
            boolean res = dfs(board, word, curIndex + 1, used, row + 1, col) ||
                    dfs(board, word, curIndex + 1, used, row - 1, col) ||
                    dfs(board, word, curIndex + 1, used, row, col + 1) ||
                    dfs(board, word, curIndex + 1, used, row, col - 1);
            if(!res){
                used[row][col] = false;
            }
            return res;
        }
    }
}
