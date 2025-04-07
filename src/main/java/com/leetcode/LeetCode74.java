package com.leetcode;

public class LeetCode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //由于矩阵本身的有序性，可以将查找二维矩阵转换为查找一维
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] < target){
                left = mid + 1;
            }else if(matrix[row][col] > target){
                right = mid - 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
