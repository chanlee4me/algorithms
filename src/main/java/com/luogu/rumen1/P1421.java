package com.luogu.rumen1;

import java.util.Scanner;

public class P1421 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        int price = 19;//单位：角
        int balance = a * 10 + b;
        int buyCount = balance / price;
        System.out.print(buyCount);
    }
}
