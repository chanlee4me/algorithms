package com.luogu.algorithm1_7;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class P1135 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // input
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        int[] k = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            k[i] = in.nextInt();
        }

        boolean[] visited = new boolean[n + 1];
        int[] steps = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            steps[i] = Integer.MAX_VALUE;
        }
        Deque<Integer> queue = new LinkedList<>();

        // bfs
        queue.add(a);
        steps[a] = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            int flag = -1;
            for (int i = 0; i < size; i++) {
                int currentLayer = queue.poll();
                if(currentLayer == b){
                    flag = 1;
                    break;
                }

                int nextUpLayer = currentLayer + k[currentLayer];
                if(nextUpLayer <= n && !visited[nextUpLayer]){
                    queue.add(nextUpLayer);
                    visited[nextUpLayer] = true;
                    steps[nextUpLayer] = steps[currentLayer] + 1;
                }

                int nextDownLayer = currentLayer - k[currentLayer];
                if(nextDownLayer >= 1 && !visited[nextDownLayer]){
                    queue.add(nextDownLayer);
                    visited[nextDownLayer] = true;
                    steps[nextDownLayer] = steps[currentLayer] + 1;
                }
            }
            if(flag == 1) break;
        }
        if(steps[b] == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.println(steps[b]);
    }

    // DFS 会栈溢出。解决最短路径更适合用 BFS
//    public static void dfs(int[] k, int currentLayer, int stepCount, int b, int a){
//        int topLayer = k.length - 1;
//        int bottomLayer = 1;
//
//        //已经超过最小步数，直接 skip
//        if(stepCount >= res) return;
//
//        //到达目标楼层，检查
//        if(currentLayer == b) {
//            res = Math.min(res, stepCount);
//            return;
//        }
//
//        //当前楼层不能移动，直接 skip
//        if(k[currentLayer] == 0) return;
//
//        //已经访问过，直接 skip
//        if(visited[currentLayer]) return;
//
//        //将当前楼层标记为访问过
//        visited[currentLayer] = true;
//
//        //往上走
//        if(currentLayer + k[currentLayer] <= topLayer)
//            dfs(k, currentLayer + k[currentLayer], stepCount + 1, b, a);
//        //往下走
//        if(currentLayer - k[currentLayer] >= bottomLayer)
//            dfs(k, currentLayer - k[currentLayer], stepCount + 1, b, a);
//
//        visited[currentLayer] = false;
//
//    }
}
