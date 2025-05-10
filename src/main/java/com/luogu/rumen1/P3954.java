package com.luogu.rumen1;

import java.util.Scanner;

public class P3954 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        int grade = (int) (a * 0.2 + b * 0.3 + c * 0.5);
        System.out.print(grade);
    }
}
