package com.luogu.algorithm1_3;

import java.util.Scanner;

public class P3654 {
    static int res = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int k = in.nextInt();
        if(k <= 0) System.out.print(0);
        in.nextLine();
        char[][] playGround = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = in.nextLine();
            char[] array = s.toCharArray();
            playGround[i] = array;
        }
        if(k == 1){
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (playGround[i][j] == '.') res++;
                }
            }
            System.out.println(res);
            return;
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(playGround[i][j] == '.'){
                    isValid(playGround, i, j, 0, k, 0);
                    isValid(playGround, i, j, 1, k, 0);
                }
            }
        }
        System.out.println(res);
    }

    /**
     *
     * @param playGround
     * @param row
     * @param col
     * @param direct 表示排列的方向 0 表示横向 1表示纵向
     * @param k
     * @param count
     */
    public static void isValid(char[][] playGround, int row, int col, int direct, int k, int count){
        if(count == k){
            res++;
            return;
        }
        int r = playGround.length;
        int c = playGround[0].length;
        if(row >= r || col >= c) return;
        if(playGround[row][col] == '.'){
            if(direct == 0) isValid(playGround, row, col + 1, direct, k, count + 1);
            if(direct == 1) isValid(playGround, row + 1, col, direct, k, count + 1);
        }
    }
}
