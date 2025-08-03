package com.huawei;

import java.util.*;

public class P3294 {
    static class Device{
        // 设备编号
        int num;
        // 设备所需集合
        Set<Integer> set;

        Device(int num){
            this.num = num;
            set = new HashSet<>();
        }
    }
    // 设备总数
    static int n;
    // 互斥设备总数
    static int m;
    // 指令总数
    static int commandNum;
    // 互斥设备编号记录
    static Set<Integer> A;
    // 指令数组
    static int[][] X;
    // 并查集数组
    static int[] parent;
    // 并查集 rank 数组
    static int[] rank;

    public static void main(String[] args) {

        init();

        // 拒绝执行的指令数统计
        int denyCount = 0;

        // 遍历指令
        for (int i = 0; i < commandNum; i++) {
            int c = X[i][0];
            int d = X[i][1];

            // 找到两者根节点
            int par1 = find(c);
            int par2 = find(d);
            // 如果处于同一集合直接跳过
            if(par2 == par1) continue;
            // 如果两个集合的根节点为互斥的，那么拒绝此指令
            if(A.contains(par2) && A.contains(par1)){
                denyCount++;
                continue;
            }else{
                merge(c,d);
            }
        }

        System.out.println(denyCount);
    }
    public static int find(int x){
        if(parent[x] == x)
            return x;
        else{
            return find(parent[x]);
        }
    }
    public static void merge(int x, int y){
        //找到根节点
        int root1 = find(x);
        int root2 = find(y);
        // 如果都是或者都不是互斥设备，那么根据 rank 来合并
        if((A.contains(root1) && A.contains(root2))
            || (!A.contains(root1) && !A.contains(root2))){
            if(rank[root1] <= rank[root2]){
                parent[root1] = root2;
            }else{
                parent[root2] = root1;
            }
            if(rank[root1] == rank[root2]){
                rank[root2]++;
            }
        }
        // 如果其中一个不是互斥设备，那么把互斥设备作为根节点
        else{
            // 找到互斥设备
            int bad = root1;
            int good = root2;
            if(A.contains(root2)){
                bad = root2;
                good = root1;
            }
            parent[good] = bad;
            rank[bad] = Math.max(rank[bad], rank[good] + 1);
        }
    }
    public static void init(){
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        commandNum = in.nextInt();

        // 初始化并查集数组
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        // 初始化并查集rank数组
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 1;
        }
        A = new HashSet<>();
        for (int i = 0; i < m; i++) {
            A.add(in.nextInt());
        }

        X = new int[commandNum][2];
        for (int i = 0; i < commandNum; i++) {
            X[i][0] = in.nextInt();
            X[i][1] = in.nextInt();
        }
        in.close();
    }
}
