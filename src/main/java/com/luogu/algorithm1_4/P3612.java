package com.luogu.algorithm1_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class P3612 {
    public static void main(String[] args) {
        /**
         * 当前字符串：S
         * 将S的最后一个字符移动到首位，得到 S'
         * 再将 S+S'
         */
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();//n 为字符串索引 + 1
        int L0 = s.length();
        long curLen = L0;
        while(curLen < n){
            curLen = curLen * 2;
        }
        while(curLen > L0){
            long half = curLen / 2;
            if(n > half){
                n -= half;
                if(n == 1){
                    n = half;
                }else{
                    n = n -1;
                }
            }
            curLen = half;
        }
        System.out.println(s.charAt((int)n - 1));
    }
}
