package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode51 {
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> solveQueens(int n){
        char[][] chessBoard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = '.';
            }
        }
        for (int i = 0; i < n; i++) {
            dfs(chessBoard, 0, i);
        }
        return res;
    }
    public void dfs(char[][] chessBoard, int row, int col){
        if(row >= chessBoard.length){
            List<String> list = new LinkedList<>();
            for (int i = 0; i < chessBoard.length; i++) {
                StringBuilder strRow = new StringBuilder();
                for (int j = 0; j < chessBoard.length; j++) {
                    strRow.append(chessBoard[i][j]);
                }
                list.add(new String(strRow.toString()));
            }
        }
        if(isValid(chessBoard, row, col)){
            chessBoard[row][col] = 'Q';
            for (int i = 0; i < chessBoard.length; i++) {
                dfs(chessBoard, row + 1, i);
            }
            chessBoard[row][col] = '.';
        }
    }

    public boolean isValid(char[][] chessBoard, int row, int col){
        //判断同一行是否存在皇后
        for (int i = 0; i < col; i++) {
            if(chessBoard[row][i] == 'Q') return false;
        }
        //判断同一列是否存在皇后
        for (int i = 0; i < row; i++) {
            if(chessBoard[i][col] == 'Q') return false;
        }
        //判断左上斜线是否存在皇后
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                if(chessBoard[i][j] == 'Q') return false;
            }
        }
        //判断右上斜线是否存在皇后
        for (int i = row - 1; i >= 0; i++) {
            for (int j = col + 1; j < chessBoard.length; j++) {
                if(chessBoard[i][j] == 'Q') return false;
            }
        }
        return true;
    }
}
