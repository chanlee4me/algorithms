package com.luogu.algorithm1_5;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class P1106 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.next();    //写入的高精度数字
        in.nextLine();
        int k = in.nextInt();   //需要删除的数字个数
        int finalSize = line.length() - k;
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);
            while(!stack.isEmpty() && k > 0  && stack.getFirst() > current){
                k--;
                stack.removeFirst();
            }
            stack.addFirst(current);
        }
        for (int i = 0; i < finalSize; i++) {
            System.out.print(stack.getLast());
            stack.removeLast();
        }
    }
}
