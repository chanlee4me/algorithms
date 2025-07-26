package com.luogu.algorithm1_7;

import java.util.*;

public class P1433 {
    static int n = 0;
    static double[][] pos;
    static double[][] dist;
    public static double res = Double.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();

        pos = new double[n][2];
        dist = new double[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            pos[i][0] = in.nextDouble();
            pos[i][1] = in.nextDouble();
        }

        // 预计算所有距离
        // dist[n][i] 表示从起点(0,0)到第i个奶酪的距离
        for (int i = 0; i < n; i++) {
            dist[n][i] = Math.sqrt(pos[i][0] * pos[i][0] + pos[i][1] * pos[i][1]);
            dist[i][n] = dist[n][i];
        }

        // dist[i][j] 表示从第i个奶酪到第j个奶酪的距离
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    double dx = pos[i][0] - pos[j][0];
                    double dy = pos[i][1] - pos[j][1];
                    dist[i][j] = Math.sqrt(dx * dx + dy * dy);
                }
            }
        }

        // 表示访问状态
        boolean[] visited = new boolean[n];

        // 尝试从每个奶酪开始
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, visited, dist[n][i], 1);
            visited[i] = false;
        }

        System.out.printf("%.2f", res);
    }

    public static void dfs(int cur, boolean[] visited, double steps, int count) {
        if (steps >= res) return; // 剪枝

        if (count == n) {
            res = Math.min(steps, res);
            return;
        }

        for (int next = 0; next < n; next++) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, visited, steps + dist[cur][next], count + 1);
                visited[next] = false;
            }
        }
    }
}
