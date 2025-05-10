package com.luogu.rumen1;

import java.util.Scanner;

public class P1425 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();

        int hourDiff = c - a;
        int minDiff = d - b;

        int timeSum = hourDiff * 60 + minDiff;//以 min 为单位
        int hour = timeSum / 60;
        int min = timeSum - hour * 60;
        System.out.println(hour + " " + min);
    }
}
