package com.luogu.algorithm1_5;

import java.util.Arrays;
import java.util.Scanner;

public class P4995 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = in.nextInt();
        }
        Arrays.sort(height);

        int left = 0;
        int right = n - 1;
        long cost = 0;
        cost += height[right] * height[right];//从地面起跳,跳到当前离他最远的石头上
        int curIndex = right;
        right--;
        while(left <= right){
            if(Math.abs(curIndex - left) > Math.abs(curIndex - right)){
                cost += (height[left] - height[curIndex]) * (height[left] - height[curIndex]);
                curIndex = left;
                left++;
            }else{
                cost += (height[right] - height[curIndex]) * (height[right] - height[curIndex]);
                curIndex = right;
                right--;
            }
        }
        System.out.println(cost);
    }
}
