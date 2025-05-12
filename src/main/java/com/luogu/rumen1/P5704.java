package com.luogu.rumen1;

import java.util.Scanner;

public class P5704 {
    public static void main(String[] args) {
        int diff = 'A' - 'a';
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char c = s.charAt(0);
        c += diff;
        System.out.println(c);
    }
}
