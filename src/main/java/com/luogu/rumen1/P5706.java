package com.luogu.rumen1;

import java.util.Scanner;

public class P5706 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double t = in.nextDouble();
        int n = in.nextInt();
        double avg = t / n;
        int cupSum = n * 2;

        System.out.printf("%.3f%n", avg);
        System.out.print(cupSum);
    }
}
