package com.thealgorithm.graph;

public class FloydWarshall {
    //假设节点之间无路径的话，矩阵中的值为INF
    private static final int INF = Integer.MAX_VALUE / 2;
    public void FloydWarshall(int[][] graph){
        int n = graph.length;
        int[][] dist = new int[n][n];

        //初始化距离矩阵
        for (int i = 0; i < n; i++) {
            //将 graph[i]中从索引0开始，复制到dist[i]中，一共 n 个元素
            System.arraycopy(graph[i], 0, dist[i], 0, n);
        }
        for (int i = 0; i < n; i++) {//确定中转节点
            for (int j = 0; j < n; j++) {//确定起始节点
                for (int k = 0; k < n; k++) {//确定终点
                    if(dist[i][k] != INF && dist[j][i] != INF){
                        dist[j][k] = Math.min(dist[j][i] + dist[i][k], dist[j][k]);
                    }
                }
            }
        }
    }
}
