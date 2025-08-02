package com.huawei;

import java.io.*;
import java.util.*;
public class P2846 {
    static final int INF = 1_000_000_000;
    // l : 线路索引  p：线路上的站点索引 t：换乘数
    static class State {
        int l, p, t;
        State(int l, int p, int t) { this.l = l; this.p = p; this.t = t; }
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        List<List<String>> lines = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            lines.add(new ArrayList<>());
            String[] strings = in.nextLine().split(" ");
            for(String s : strings){
                lines.get(i).add(s);
            }
        }
        String[] ab = in.nextLine().split(" ");
        String A = ab[0], B = ab[1];

        // 记录 站名 -> List of (线路号, 位置) 的映射
        Map<String, List<int[]>> M = new HashMap<>();
        for (int i = 0; i < N; i++) {
            // 第 i 条线上的站名列表
            List<String> ln = lines.get(i);
            for (int j = 0; j < ln.size(); j++) {
                String station = ln.get(j);
                M.putIfAbsent(station, new ArrayList<>());
                M.get(station).add(new int[]{i, j});
            }
        }
        if (!M.containsKey(A) || !M.containsKey(B)) {
            System.out.println("NA");
            return;
        }
        // D[i][j]: 到达线 i、位置 j 的最小换乘数
        int[][] D = new int[N][];
        // P 用于回溯前驱 (prev_line, prev_pos)
        // p[i][j][0]：位于线路 i 站点 j 时的前驱线路
        // p[i][j][1]：位于线路 i 站点 j 时的前驱站点
        int[][][] P = new int[N][][];
        for (int i = 0; i < N; i++) {
            int sz = lines.get(i).size();
            D[i] = new int[sz];
            P[i] = new int[sz][2];
            Arrays.fill(D[i], INF);
            for (int j = 0; j < sz; j++) {
                P[i][j][0] = P[i][j][1] = -1;
            }
        }
        Deque<State> dq = new ArrayDeque<>();
        // 遍历起点位于的地铁线路&站点索引
        for (int[] pr : M.get(A)) {
            //  l：线路 p：索引
            int l = pr[0], p = pr[1];
            D[l][p] = 0;
            dq.addLast(new State(l, p, 0));
        }
        boolean found = false;
        int el = -1, ep = -1;
        while (!dq.isEmpty()) {
            State cur = dq.pollFirst();
            int l = cur.l, p = cur.p, t = cur.t;
            if (lines.get(l).get(p).equals(B)) {
                found = true; el = l; ep = p; break;
            }
            if (t > D[l][p]) continue;
            // 同线移动（权重0）
            for (int np : new int[]{p-1, p+1}) {
                if (np >= 0 && np < lines.get(l).size() && t < D[l][np]) {
                    D[l][np] = t;
                    P[l][np] = new int[]{l, p};
                    dq.addFirst(new State(l, np, t));
                }
            }
            // 换乘（权重1）
            String curSt = lines.get(l).get(p);
            for (int[] pr : M.get(curSt)) {
                int nl = pr[0], np = pr[1];
                if (nl == l) continue;
                if (t + 1 < D[nl][np]) {
                    D[nl][np] = t + 1;
                    P[nl][np] = new int[]{l, p};
                    dq.addLast(new State(nl, np, t + 1));
                }
            }
        }
        if (!found) {
            System.out.println("NA");
            return;
        }
        // 回溯
        List<int[]> path = new ArrayList<>();
        int l = el, p = ep;
        while (l != -1) {
            path.add(new int[]{l, p});
            int nl = P[l][p][0], np = P[l][p][1];
            l = nl; p = np;
        }
        Collections.reverse(path);
        // 提取路线
        List<String> route = new ArrayList<>();
        int prevL = path.get(0)[0], prevP = path.get(0)[1];
        route.add(lines.get(prevL).get(prevP));
        for (int i = 1; i < path.size(); i++) {
            int cl = path.get(i)[0], cp = path.get(i)[1];
            if (cl != prevL) {
                route.add(lines.get(cl).get(cp));
            }
            prevL = cl; prevP = cp;
        }
        if (!route.get(route.size()-1).equals(B)) {
            route.add(B);
        }
        int transfers = route.size() - 2;
        int fare = 2 + transfers;
        System.out.println(String.join("-", route));
        System.out.println(fare);
    }
}

