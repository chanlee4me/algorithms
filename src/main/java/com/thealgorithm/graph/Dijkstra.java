package com.thealgorithm.graph;

import java.util.Arrays;

public class Dijkstra {
    private static final int INF = Integer.MAX_VALUE / 2; // 表示无穷大，用 MAX_VALUE / 2防止溢出
    public int[] dijkstra(int[][] graph, int start){
        int n = graph.length; // 顶点数量
        int[] dist = new int[n]; // 存储起始点到各点的最短距离
        boolean[] checked = new boolean[n]; // 标记顶点是否已找到最短路径
        int[] parent = new int[n];  //记录每个节点的前驱节点

        //初始化
        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);
        dist[start] = 0;
        //主循环，更新最短路径
        while(true){
            int u = -1;//记录距当前节点路径最短的那个节点
            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {// 在未确定最短路径的节点中选择距离起始节点最近的节点
                if (!checked[j] && dist[j] < minDist) {
                    u = j;
                    minDist = dist[j];
                }
            }
            // 如果所有节点的最短路径都已确定，退出
            if(u == -1) break;
            // 将节点u标记为已检查
            checked[u] = true;
            //把节点 u 作为中转节点，来更新邻居节点的最短路径
            for (int v = 0; v < n; v++) {
                if(graph[u][v] != 0 && !checked[v]) {// 如果u到v有边
                    //更新路径
                    if(dist[u] + graph[u][v] < dist[v]){
                        dist[v] = Math.min(dist[u] + graph[u][v], dist[v]);
                        parent[v] = u;
                    }
                }
            }
        }
        return dist;
    }
}
