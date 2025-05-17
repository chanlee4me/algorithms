package com.luogu.algorithm1_2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P1059 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(in.nextInt());
        }
        System.out.println(set.size());
        int count = 0;
        for (int i : set) {
            if(count > 0) System.out.print(" ");
            count++;
            System.out.print(i);
        }
    }
}
