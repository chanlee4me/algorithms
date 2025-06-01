package com.luogu.algorithm1_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1706 {
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[n + 1];
        backtrack(path, used, n);
        for(int i = 0; i < list.size(); i++){
            path = list.get(i);
            for (Integer val : path){
                System.out.printf("%5d", val);
            }
            if(i < list.size() - 1)
                System.out.println("");
        }
    }
    private static void backtrack(List<Integer> path, boolean[] used, int n){
        if(path.size() == n){
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(used[i]) continue;
            path.add(i);
            used[i] = true;
            backtrack(path, used, n);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
