package com.luogu.algorithm1_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2404 {
    static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();

        for (int i = 1; i <= n / 2; i++) {
            List<Integer> path = new ArrayList<>();
            path.add(i);
            dfs(i, i, path);
            path.remove(path.size() - 1);
        }
    }

    public static void dfs(int preNum, int sum, List<Integer> path){
        if(sum == n){
            printRes(path);
            return;
        }
        for (int nextNum = preNum; nextNum < n; nextNum++) {
            if(sum + nextNum > n) return;
            path.add(nextNum);
            dfs(nextNum, sum + nextNum, path);
            path.remove(path.size() - 1);
        }
    }

    public static void printRes(List<Integer> path){
        for (int i = 0; i < path.size(); i++) {
            if(i == 0)
                System.out.print(path.get(i));
            else
                System.out.print("+" + path.get(i));
        }
        System.out.println();
    }
}
