package com.leetcode;

public class Leetcode240 {
    public static boolean func(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        while(row < m && col >= 0){
            int curVal = matrix[row][col];
            if(curVal > target){
                col--;
            }else if(curVal < target){
                row++;
            }else{
                return true;
            }
        }
        return false;
    }

}
