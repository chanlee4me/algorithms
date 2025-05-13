package com.luogu.algorithm1_1;

import java.util.Scanner;

public class P4924 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        //init matrix
        int[][] matrix = new int[n][n];
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = count;
                count++;
            }
        }
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int r = in.nextInt();
            int z = in.nextInt();
            rotate(matrix, x - 1, y - 1, 2 * r + 1, z);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j < n - 1)
                    System.out.printf(matrix[i][j] + " ");
                else
                    System.out.print(matrix[i][j]);
            }
            if(i < n - 1) System.out.println("");
        }
    }

    /**
     *
     * @param matrix
     * @param row       中心点的行
     * @param col       中心点的列
     * @param n         涉及到的矩阵行数
     * @param direct    旋转方向 0：顺时针，1：逆时针
     */
    public static void rotate(int[][] matrix, int row, int col, int n, int direct){
        int top = row - n / 2;
        int down = row + n / 2;
        int left = col - n / 2;
        int right = col + n / 2;
        if(top < 0 || down >= matrix.length || left < 0 || right >= matrix.length) return;

        if(direct == 0){
            while(left < right && top < down){
                for (int i = 0; i < right - left; i++) {
                    int temp = matrix[top][left + i];
                    matrix[top][left + i] = matrix[down - i][left];
                    matrix[down - i][left] = matrix[down][right - i];
                    matrix[down][right - i] = matrix[top + i][right];
                    matrix[top + i][right] = temp;
                }
                left++; right--;
                top++; down--;
            }
        }
        if(direct == 1){
            while(left < right && top < down){
                for (int i = 0; i < right - left; i++) {
                    int temp = matrix[top][right - i];
                    matrix[top][right - i] = matrix[down - i][right];
                    matrix[down - i][right] = matrix[down][left + i];
                    matrix[down][left + i] = matrix[top + i][left];
                    matrix[top + i][left] = temp;
                }
                left++; right--;
                top++; down--;
            }
        }
    }
}
