package com.luogu.algorithm1_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P1098 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p1 = in.nextInt();
        int p2 = in.nextInt();
        int p3 = in.nextInt();
        in.nextLine();
        String line = in.nextLine();

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            //检查当前字符是否是可能用于展开的减号
            if(currentChar == '-' && i > 0 && i < line.length() - 1){
                char prevChar = line.charAt(i - 1);
                char nextChar = line.charAt(i + 1);

                //条件 1：减号两侧同为小写字母或同为数字
                boolean isLowerLetter = Character.isLowerCase(prevChar) && Character.isLowerCase(nextChar);
                boolean isDigit = Character.isDigit(prevChar) && Character.isDigit(nextChar);

                //条件 2：减号右边的字符严格大于左边的字符
                boolean isIncreaseOrder = nextChar > prevChar;

                if((isLowerLetter || isDigit) && isIncreaseOrder){
                    if(nextChar == prevChar + 1){
                        //右边的字符恰好是左边字符 的后继
                        continue;
                    }else{
                        char start = (char) (prevChar + 1);
                        char end = (char) (nextChar - 1);
                        fill(res, start, end, p1, p2 , p3, isLowerLetter);
                    }
                }else {//不满足条件，保留"-"
                    res.append(currentChar);
                }
            }else{//非“-”，或者“-”在首尾无法展开
                res.append(currentChar);
            }
        }
        System.out.print(res);
    }
    public static void fill(StringBuilder res, char start, char end, int p1, int p2, int p3, boolean isLetterExpansion){
        StringBuilder s = new StringBuilder();

        for (char c = start; c <= end; c++) {
            char fillC;
            if(p1 == 3){
                fillC = '*';
            }else{
                if(isLetterExpansion) {//字母展开
                    if (p1 == 1) {//填充小写字母
                        fillC = Character.toLowerCase(c);
                    }else{
                        fillC = Character.toUpperCase(c);
                    }
                }else{
                    fillC = c;
                }
            }
            s.append(build(fillC, p2));
        }
        if(p3 == 2){
            s.reverse();
        }
        res.append(s);
    }
    public static StringBuilder build(char c, int loopTime){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < loopTime; i++) {
            s.append(c);
        }
        return s;
    }
}
