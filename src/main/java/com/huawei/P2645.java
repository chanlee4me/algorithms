package com.huawei;

import java.util.*;

public class P2645 {

    static int res;
    static boolean[][] graph;
    private static int[] colors;
    static int n;
    public static void main(String[] args) {
        // init
        Scanner in = new Scanner(System.in);
        // 参加测试的人数（从 1 到 n 编号）
        n = in.nextInt();
        res = n;
        int m = in.nextInt();
        graph = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            graph[a][b] = true;
            graph[b][a] = true;
        }

        colors = new int[n];
        Arrays.fill(colors, -1);

        backtrack(0, new HashSet<>());

        System.out.println(res);
    }
    public static void backtrack(int id, Set<Integer> path){
        if(path.size() >= res) return;
        if(id == n){
            res = Math.min(res, path.size());
            return;
        }
        // 对每个顶点，尝试所有的设备（颜色）
        for (int i = 0; i < n; i++) {
            if(isValid(id, i)){
                colors[id] = i;
                if(!path.contains(i)){
                    path.add(i);
                    backtrack(id + 1, path);
                    path.remove(i);
                }else{
                    backtrack(id + 1, path);
                }
                colors[id] = -1;
            }
        }
        return;
    }
    public static boolean isValid(int i, int color){
        for (int j = 0; j < n; j++) {
            if(graph[i][j] && colors[j] == color){
                return false;
            }
        }
        return true;
    }
}

