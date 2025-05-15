package com.luogu.algorithm1_1;

import java.util.Scanner;

public class P1067 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            int cur = in.nextInt(); //系数
            if(cur == 0) continue;
            int index = n - i; //当前项的指数
            //构造项的字符串（不含符号）
            String suffixNoSign= "";
            int absCur = Math.abs(cur);
            if(index == 0){//常数项
                suffixNoSign = Integer.toString(absCur);
            }else{
                //构造非指数项
                if(absCur == 1){
                    suffixNoSign = "x";
                }else{
                    suffixNoSign = absCur + "x";
                }
                //构造指数
                if(index > 1){
                    suffixNoSign += "^" + index;
                }
            }
            //处理符号
            if(s.length() == 0){//第一个要添加的项
                if(cur < 0) s.append("-");
                s.append(suffixNoSign);
            }else{
                if(cur < 0) s.append("-");
                else s.append("+");
                s.append(suffixNoSign);
            }
        }
        if(s.length() == 0){
            System.out.print("0");
        }else{
            System.out.print(s);
        }
    }
}
