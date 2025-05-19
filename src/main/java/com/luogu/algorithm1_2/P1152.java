package com.luogu.algorithm1_2;

import java.util.Scanner;

/**
 * 用一个数组来标识绝对值是否已经出现过
 */
public class P1152 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[] appear = new boolean[n];
        int prev = 0;
        for (int i = 0; i < n; i++) {
            if(i == 0){
                prev = in.nextInt();
            }else{
                int cur = in.nextInt();
                int diff = Math.abs(cur - prev);
                if(diff < n)
                    appear[diff] = true;
                prev = cur;
            }
        }
        boolean flag = true;
        for (int i = 1; i < n; i++) {
            if(appear[i] == false){
                flag = false;
                break;
            }
        }
        String res = flag == true ? "Jolly" : "Not jolly";
        System.out.print(res);
    }

}
