package com.luogu.rumen1;

import java.util.Scanner;

public class P5705 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = "";
        for (int i = s1.length() - 1; i >= 0; i--) {
            s2 += s1.charAt(i);
        }
        double v = Double.parseDouble(s2);
        System.out.print(v);
    }
}
