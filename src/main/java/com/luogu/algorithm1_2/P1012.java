package com.luogu.algorithm1_2;

import java.util.Arrays;
import java.util.Scanner;

public class P1012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] arr = new String[n];
        arr = in.nextLine().split(" ");
        Arrays.sort(arr, (a, b) -> {
            int sizeA = a.length();
            int sizeB = b.length();
            for (int i = 0; i < Math.min(sizeA, sizeB); i++) {
                int numA = a.charAt(i);
                int numB = b.charAt(i);
                if(numB != numA){
                    return Integer.compare(numB, numA);
                }
            }
            return (b + a).compareTo(a + b);
        });
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(arr[i]);
        }
        System.out.print(s);
    }
}
