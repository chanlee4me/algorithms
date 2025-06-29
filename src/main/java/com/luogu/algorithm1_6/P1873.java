package com.luogu.algorithm1_6;

import java.awt.event.HierarchyBoundsAdapter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1873 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //树木的数量
        int m = in.nextInt(); //木材总长度
        int maxHeight = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            maxHeight = Math.max(maxHeight, temp);
        }
        //求锯子的最高高度（这样使得砍得的树木最少）
        //将树木排序 --> 锯子以中间高度的树木初始化 - 1为基准，逐渐减少
        int low = 1;
        int high = maxHeight;
        int res = -1;
        while(low <= high){
            int curHeight = low + (high - low) / 2;
            long cutSum = 0;
            for(Integer h : map.keySet()) {
                if(h > curHeight){
                    cutSum += (h - curHeight) * map.get(h);
                }
            }
            if(cutSum >= m){
                res = curHeight;
                low = curHeight + 1;
            }else{
                high = curHeight - 1;
            }
        }
        System.out.println(res);
    }
}
