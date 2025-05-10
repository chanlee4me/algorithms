package com.luogu.rumen1;

import java.util.Scanner;

public class P5707 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int v = in.nextInt();

        double totalCostTime = (double) s / v + 10;

        int needActualTime = (int)totalCostTime;
        if(needActualTime < totalCostTime){
            needActualTime += 1;//不足 1min 按 1min 算
        }
        int needHour = needActualTime / 60;
        int minit = needActualTime % 60;
        int startHour = 8;
        int startMinit = 60;
        if(minit > 0){
            startMinit -= minit;
            startHour--;
        }
        startHour -= needHour;
        if(startHour < 0){
            startHour += 24;
        }
        System.out.printf("%02d:%02d", startHour, startMinit);
    }
}
