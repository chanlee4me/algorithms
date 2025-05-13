package com.luogu.algorithm1_1;

import java.math.BigInteger;
import java.util.Scanner;

public class P1601 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger a = in.nextBigInteger();
        in.nextLine();
        BigInteger b = in.nextBigInteger();
        BigInteger sum = a.add(b);
        System.out.print(sum);
    }
}
