package com.luogu.algorithm1_5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1090 {
    /**
     * 果子按照种类划分为不同堆
     * 每次合并，消耗体力 = 两堆果子重量和
     * 每个果子重量为 1
     * 已知果子的种类 数和每种果子的数目；怎么合并才能让消耗的体力最少
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//果子种类数
        int[] arr = new int[n];//arr[i]：第 i 种果子的数量
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            minHeap.add(arr[i]);
        }
        //每次都将最小的两堆进行合并，用最小堆
        int count = 0;
        while(minHeap.size() >= 2){
            //移除最小的两部分
            int a = minHeap.remove();
            int b = minHeap.remove();
            int weight = a + b;
            count += weight;
            minHeap.add(weight);
        }
        System.out.println(count);
    }
}
