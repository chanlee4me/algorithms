package com.luogu.algorithm1_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1157 {
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        if(r == 0) return;
        List<Integer> path = new ArrayList<>();
        backtrack(path, 0, 1, n, r);
        for(int i = 0; i < list.size(); i++){
            path = list.get(i);
            for (Integer val : path){
                System.out.printf("%3d", val);
            }
            if(i < list.size() - 1)
                System.out.println("");
        }
    }
    private static void backtrack(List<Integer> path, int depth, int index, int n, int r){
        if(depth == r){
            list.add(new ArrayList<>(path));
            return;
        }
        if(index > n) return;

        for (int i = index; i <= n; i++) {
            path.add(i);
            backtrack(path, depth + 1, i + 1, n, r);
            path.remove(path.size() - 1);
        }
    }
}
