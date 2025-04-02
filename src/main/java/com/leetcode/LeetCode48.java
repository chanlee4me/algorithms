package com.leetcode;

import javax.print.attribute.EnumSyntax;

public class LeetCode48 {    private static void reverseMatrix(int[][] matrix){
    int n = matrix.length;
    int top = 0, down = n - 1;
    int left = 0, right = n - 1;
    while(top < down && left < right){
        for (int i = 0; i < right - left; i++) {
            int temp = matrix[top][left + i];
            matrix[top][left + i] = matrix[down - i][left];
            matrix[down - i][left] = matrix[down][right - i];
            matrix[down][right - i] = matrix[top + i][right];
            matrix[top + i][right] = temp;
        }
        top++; down--;
        left++; right--;
    }
}


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };
        reverseMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println("");
        }
    }
}
