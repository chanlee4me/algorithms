package com.luogu.algorithm1_6;

import java.util.Arrays;
import java.util.Scanner;

public class P1678 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] scoreLineArray = new int[m];
        int[] score = new int[n];
        for (int i = 0; i < m; i++) {
            scoreLineArray[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            score[i] = in.nextInt();
        }
        Arrays.sort(scoreLineArray);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += binarySearch(scoreLineArray, score[i]);
        }
        System.out.println(res);
    }
    public static int binarySearch(int[] scoreLineArray, int score){
        int left = 0;
        int right = scoreLineArray.length - 1;
        int target = scoreLineArray[0];
        while(left <= right){
            int mid = left + (right - left) / 2;
            int diff1 = Math.abs(scoreLineArray[mid] - score);
            int diff2 = Math.abs(target - score);
            if(scoreLineArray[mid] < score){
                left = mid + 1;
            }else if(scoreLineArray[mid] > score){
                right = mid - 1;
            }else{
                return 0;
            }
            target = diff1 < diff2 ? scoreLineArray[mid] : target;
        }
        return Math.abs(target - score);
    }
}
