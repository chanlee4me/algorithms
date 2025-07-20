package com.luogu.algorithm1_6;

import java.util.Scanner;

public class P1182 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] array = new int[n];
        int sum = 0;
        int maxElem = 0;
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
            sum += array[i];
            maxElem = Math.max(maxElem, array[i]);
        }
        int left = maxElem;
        int right = sum;
        int res = sum;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(check(array, mid, m)){
                res = Math.min(mid, res);
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(res);
    }
    public static boolean check(int[] array, int maxLength, int m){
        int cnt = 1;//记录段数
        int curSum = 0;
        for (int i = 0; i < array.length; i++) {
            if(curSum + array[i] > maxLength){
                cnt++;
                curSum = array[i];
                if(cnt > m) break;
            }else{
                curSum += array[i];
            }
        }
        if(cnt <= m) return true;
        else return false;
    }
}
