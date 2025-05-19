package com.luogu.algorithm1_2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N头奶牛，已知每头的身高，
 * 书架高度是B
 * 要让奶牛塔的高度 >= B，且牛尽可能地少
 * 那么先对奶牛排序，从高到低依次加奶牛，直到达到 B
 */
public class P2676 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int B = in.nextInt();
        Integer[] height = new Integer[N];
        for (int i = 0; i < N; i++) {
            height[i] = in.nextInt();
        }
        Arrays.sort(height, (a, b) -> b.compareTo(a));
        int cowCount = 0;
        int towerHeight = 0;
        for (int i = 0; i < N; i++) {
            cowCount++;
            towerHeight += height[i];
            if(towerHeight >= B) break;
        }
        System.out.print(cowCount);
    }
}
