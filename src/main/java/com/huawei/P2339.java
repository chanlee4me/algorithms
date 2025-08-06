package com.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P2339 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] strings = in.nextLine().split(",");
        int n = strings.length;
        Map<Integer, Integer> map = new HashMap<>();

        int maxCount = 0;
        int suspect = -1;
        for (String s : strings){
            int num = Integer.parseInt(s);
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
            if(maxCount < map.get(num)){
                maxCount = map.get(num);
                suspect = num;
            }
        }
        if(n % 2 == 0 && maxCount <= n / 2){
            System.out.println(0);
            return;
        }
        if(n % 2 != 0 && maxCount <= n / 2){
            System.out.println(0);
            return;
        }
        System.out.println(suspect);
    }
}
