package com.luogu.algorithm1_6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1102 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 0);
            }
            map.put(arr[i], map.get(arr[i]) + 1);
        }
        for(Integer a : map.keySet()){
            int b = a - c;
            if(map.containsKey(b)){
                count += (long)map.get(a) * map.get(b);
            }
        }
        System.out.println(count);
    }
}
