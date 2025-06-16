package com.luogu.algorithm1_5;

import java.util.Arrays;
import java.util.Scanner;

public class P1223 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] timeArray = new int[n][2];//第一维表示初始索引，第二维表示接水时间
        for (int i = 0; i < n; i++) {
            timeArray[i][0] = i + 1;
            timeArray[i][1] = in.nextInt();
        }
        Arrays.sort(timeArray, (a, b)->{
            return Integer.compare(a[1], b[1]);
        });
        double timeWaitSum = 0;
        double curTimeSum = 0;
        for (int i = 0; i < n; i++) {
            if(i == 0){
                System.out.print(timeArray[i][0]);
            }else{
                System.out.print(" " + timeArray[i][0]);
            }
            timeWaitSum += curTimeSum;
            curTimeSum += timeArray[i][1];
        }
        System.out.println();
        System.out.printf("%.2f", timeWaitSum / n);
    }
}
