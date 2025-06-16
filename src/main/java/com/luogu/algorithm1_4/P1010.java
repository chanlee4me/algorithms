package com.luogu.algorithm1_4;

import java.util.*;

public class P1010 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(getCombo(n));
    }
    public static String getCombo(int n){
        if(n == 1) {
            return "2(0)";
        }
        if(n == 2){
            return "2";
        }
        int e = getHighNum(n);
        int cur = (int) Math.pow(2, e);
        String part = "";
        if(e == 1) part = "2";
        else{
            part = "2(" + getCombo(e) + ")";
        }
        if(n == cur) return part;
        else{
            return part + "+" + getCombo(n - cur);
        }
    }
    //找到组成 2的幂次方组合的最高位次数
    public static int getHighNum(int n){
        int cur = 1;
        int count = 0;
        while(cur < n){
            cur = cur * 2;
            count++;
            if(cur < n) continue;
            if(cur > n){
                count--;
            }
            break;
        }
        return count;
    }
}
