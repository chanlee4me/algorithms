package com.luogu.algorithm1_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P1219 {
    public static int resCount = 0;
    public static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[][] chessBoard = new char[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(chessBoard[i], '.');
        }
        dfs(chessBoard, 0, new ArrayList<>());
        //print
        System.out.println();
        System.out.println(resCount);
    }
    public static void dfs(char[][] chessBoard, int row, List<Integer> list){
        if(list.size() == chessBoard.length){
            resCount++;
            if(count == 0){
                print(list);
            }
            else if(count <= 2){
                System.out.println();
                print(list);
            }
            count++;
            return;
        }
        for (int i = 0; i < chessBoard.length; i++) {
            if(check(chessBoard, row, i)){
                list.add(i + 1);
                chessBoard[row][i] = 'Q';
                dfs(chessBoard, row + 1, list);
                chessBoard[row][i] = '.';
                list.remove(list.size() - 1);
            }
        }
    }
    public static boolean check(char[][] chessBoard, int row, int col){
        //检查当前列
        for (int i = 0; i < row; i++) {
            if(chessBoard[i][col] == 'Q') return false;
        }
        //检查左上斜线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(chessBoard[i][j] == 'Q') return false;
        }
        //检查右上斜线
        for (int i = row - 1, j = col + 1; i >= 0 && j < chessBoard.length; i--, j++) {
            if(chessBoard[i][j] == 'Q') return false;
        }
        return true;
    }
    public static void print(List<Integer> list){
        for (int j = 0; j < list.size(); j++) {
            if(j != 0)
                System.out.printf(" " + list.get(j));
            else
                System.out.print(list.get(j));
        }
    }
}
