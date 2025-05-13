package com.luogu.algorithm1_1;

import java.math.BigInteger;
import java.util.Scanner;

public class P1009 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        BigInteger res = BigInteger.valueOf(0);
        for (int i = 1; i <= n; i++) {
            res = res.add(func(i));
        }
        System.out.print(res);
    }
    public static BigInteger func(int n){
        BigInteger res = BigInteger.valueOf(1);
        for(int i = 1; i <= n; i++){
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
}
