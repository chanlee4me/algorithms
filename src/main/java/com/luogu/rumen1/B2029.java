package com.luogu.rumen1;

import java.util.Scanner;

public class B2029 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int r = in.nextInt();

        double volume = 3.14 * r * r * h / 1000;
        double count = 20 / volume;
        int res = (int) Math.ceil(count);
        System.out.println(res);
    }
}
