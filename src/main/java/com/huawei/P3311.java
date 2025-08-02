package com.huawei;

import java.util.Scanner;

public class P3311{
    public static int[] array;
    public static  int res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        array = new int[m];
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }

        res = 0;

        for (int mid = 0; mid < array.length; mid++) {// 以每个点都作为一次中心点，向两侧遍历
            int l = mid;
            // 向左扩展（需要左侧元素小于等于当前元素）
            while(l > 0 && array[l - 1] <= array[l]){
                l--;
            }
            //向右扩展
            int r = mid;
            while(r < array.length - 1 && array[r] >= array[r + 1]){
                r++;
            }
            // 计算最大差值
            if(l < mid && r > mid){
                int min = Math.min(array[l], array[r]);
                res = Math.max(res, array[mid] - min);
            }
        }
        System.out.println(res);
    }
}