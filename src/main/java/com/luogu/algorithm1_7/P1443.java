package com.luogu.algorithm1_7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1443 {
    // 八个马走日方向
    private static final int[][] DIRS = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;

        int[][] chessBoard = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                chessBoard[i][j] = -1;
            }
        }
        bfs(chessBoard, x, y);
        for (int i = 0; i < n; i++) {
            if(i != 0)
                System.out.println();
            for (int j = 0; j < m; j++) {
                if(j != 0)
                    System.out.printf(" " + chessBoard[i][j]);
                else
                    System.out.print(chessBoard[i][j]);
            }
        }
    }

    private static void bfs(int[][] chessBoard, int row, int col){
        int n = chessBoard.length;
        int m = chessBoard[0].length;
        Queue<int[]> queue = new LinkedList<>();
        chessBoard[row][col] = 0;
        queue.offer(new int[]{row, col});
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            int x = p[0], y = p[1];
            int d = chessBoard[x][y];

            for (int[] dir : DIRS) {
                int nx = x + dir[0], ny = y + dir[1];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && chessBoard[nx][ny] == -1){
                    chessBoard[nx][ny] = d + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

//    public static void dfs(int[][] chessBoard, int row, int col){
//        //判断当前位置是否合法
//        if(row >= chessBoard.length || row < 0 || col >= chessBoard[0].length || col < 0){
//            return;
//        }
//        //更新所有能到的位置的最短步数
//        if(check(chessBoard, row + 2, col + 1)){
//            int pre = chessBoard[row + 2][col + 1];
//            int cur = chessBoard[row][col] + 1;
//            if(cur < pre || pre == -1){
//                chessBoard[row + 2][col + 1] = cur;
//                dfs(chessBoard, row + 2, col + 1);
//            }
//        }
//        if(check(chessBoard, row + 2, col - 1)){
//            int pre = chessBoard[row + 2][col - 1];
//            int cur = chessBoard[row][col] + 1;
//            if(cur < pre || pre == -1){
//                chessBoard[row + 2][col - 1] = cur;
//                dfs(chessBoard, row + 2, col - 1);
//            }
//        }
//        if(check(chessBoard, row - 2, col - 1)){
//            int pre = chessBoard[row - 2][col - 1];
//            int cur = chessBoard[row][col] + 1;
//            if(cur < pre || pre == -1){
//                chessBoard[row - 2][col - 1] = cur;
//                dfs(chessBoard, row - 2, col - 1);
//            }
//        }
//        if(check(chessBoard, row - 2, col + 1)){
//            int pre = chessBoard[row - 2][col + 1];
//            int cur = chessBoard[row][col] + 1;
//            if(cur < pre || pre == -1){
//                chessBoard[row - 2][col + 1] = cur;
//                dfs(chessBoard, row - 2, col + 1);
//            }
//        }
//        if(check(chessBoard, row - 1, col + 2)){
//            int pre = chessBoard[row - 1][col + 2];
//            int cur = chessBoard[row][col] + 1;
//            if(cur < pre || pre == -1){
//                chessBoard[row - 1][col + 2] = cur;
//                dfs(chessBoard, row - 1, col + 2);
//            }
//        }
//        if(check(chessBoard, row - 1, col - 2)){
//            int pre = chessBoard[row - 1][col - 2];
//            int cur = chessBoard[row][col] + 1;
//            if(cur < pre || pre == -1){
//                chessBoard[row - 1][col - 2] = cur;
//                dfs(chessBoard, row - 1, col - 2);
//            }
//        }
//        if(check(chessBoard, row + 1, col - 2)){
//            int pre = chessBoard[row + 1][col - 2];
//            int cur = chessBoard[row][col] + 1;
//            if(cur < pre || pre == -1){
//                chessBoard[row + 1][col - 2] = cur;
//                dfs(chessBoard, row + 1, col - 2);
//            }
//        }
//        if(check(chessBoard, row + 1, col + 2)){
//            int pre = chessBoard[row + 1][col + 2];
//            int cur = chessBoard[row][col] + 1;
//            if(cur < pre || pre == -1){
//                chessBoard[row + 1][col + 2] = cur;
//                dfs(chessBoard, row + 1, col + 2);
//            }
//        }
//    }
    public static boolean check(int[][] chessBoard, int row, int col){
        if(row >= chessBoard.length || row < 0 || col >= chessBoard[0].length || col < 0) return false;
        else return true;
    }
}
