package com.meituan;

import java.util.Scanner;

//2024年春招-美团-技术岗-第一批笔试-第四题
// 59分开始，耗时 分钟，通过：
public class P4 {
    static int[] count;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 总人数
        int n = in.nextInt();
        // 初始的朋友关系数量
        int m = in.nextInt();
        // 事件数量
        int q = in.nextInt();
        // 初始化并查集
        int[] parent = new int[n + 1];
        init(parent);

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            merge(u, v, parent);
        }
        // op

        for (int i = 0; i < q; i++) {
            int op = in.nextInt();
            int u = in.nextInt();
            int v = in.nextInt();
            int root1 = find(u, parent);
            int root2 = find(v, parent);
            if(op == 1){
                // 如果直接相连，那么断掉
                if(parent[u] == v) parent[u] = u;
                if(parent[v] == u) parent[v] = v;
            }
            if(op == 2){
                // 能否间接认识
                if(root1 == root2){
                    System.out.println("Yes");
                    continue;
                }
                System.out.println("No");

            }
        }
    }
    public static void init(int[] parent){
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }
    public static int find(int x, int[] parent){
        if(parent[x] == x){
            return x;
        }else{
            return find(parent[x], parent);
        }
    }
    public static void merge(int x, int y, int[] parent){
        int root1 = find(x, parent);
        int root2 = find(y, parent);
        parent[root1] = root2;
    }
}
