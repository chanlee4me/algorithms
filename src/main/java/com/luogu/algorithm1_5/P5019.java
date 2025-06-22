package com.luogu.algorithm1_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P5019 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//路的总长度（区域个数）
        int[] deep = new int[n];//每个区域的下陷深度（>=0)
        List<Integer> edge = new ArrayList<>();//记录初始时的 0 下陷的位置
        for (int i = 0; i < n; i++) {
            deep[i] = in.nextInt();
            if(deep[i] == 0) edge.add(i);
        }
        for (int i = 0; i < edge.size(); i++){
            if(i == 0)
                func(deep, 0, edge.get(i) - 1);
            else if(i == edge.size() - 1){
                func(deep,edge.get(i) + 1, n - 1);
            }else{
                func(deep, edge.get(i - 1) + 1, edge.get(i) - 1);
            }
        }
        if(edge.size() == 0) func(deep, 0, n - 1);
        System.out.println(count);
    }
    public static void func(int[] deep, int left, int right){
        if(left > right || left < 0 || right >= deep.length) return;
        //找到当前路段的最小下陷
        int minDeep = deep[left];
        for (int i = left + 1; i <= right; i++) {
            if(deep[i] < minDeep){
                minDeep = deep[i];
            }
        }
        List<Integer> edge = new ArrayList<>();//记录填充后的 0 下陷的位置
        //将每段区域填充 minDeep
        for (int i = left; i <= right; i++) {
            deep[i] -= minDeep;
            if(deep[i] == 0) edge.add(i);
        }
        count += minDeep;
        if(edge.size() == 0) func(deep, left, right);
        else if(edge.size() == 1){
            if(edge.get(0) == left) func(deep, left + 1, right);
            else if(edge.get(0) == right) func(deep, left, right - 1);
            else {
                func(deep, left, edge.get(0) - 1);
                func(deep, edge.get(0) + 1, right);
            }
        }else{
            for (int i = 0; i < edge.size(); i++){
                if(i == 0)
                    func(deep, left, edge.get(i) - 1);
                else{
                    func(deep, edge.get(i - 1) + 1, edge.get(i) - 1);
                    if(i == edge.size() - 1)
                        func(deep,edge.get(i) + 1, right);
                }
            }
        }
    }
}
