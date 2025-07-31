package com.huawei;

import java.util.*;

public class P2845 {
    // 记录用例使用情况
    static boolean[] used;
    // 记录模块覆盖情况
    static boolean[] coverCheck;
    // 当前最小集合大小
    static long curRes;
    // 用例总数
    static int i;
    // 模块总数
    static int j;
    // 每个用例能覆盖的模块映射关系
    static Map<Integer, List<Integer>> map;
    //
    static List<Integer> set;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 用例总数
        i = in.nextInt();
        used = new boolean[i];
        // 模块总数
        j = in.nextInt();
        coverCheck = new boolean[j];
        // 消耗换行符
        in.nextLine();
        // map.get(i) 表示用例 i 能够覆盖的模块集合
        map = new HashMap<>();
        for (int k = 0; k < i; k++) {
            map.put(k, new ArrayList<>());
            List<Integer> list = map.get(k);
            String[] strings = in.nextLine().split(" ");
            for (int l = 0; l < strings.length; l++) {
                if (strings[l].equals("1")) {
                    list.add(l);
                }
            }
        }
        curRes = Long.MAX_VALUE;
        //TODO
        set = new ArrayList<>();
        dfs(0);
        if(curRes == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(curRes);
    }

    public static void dfs(int coverCount){
        if(coverCount == j){
            curRes = Math.min(curRes, set.size());
            return;
        }
        
        if(set.size() >= curRes) return;

        for (int k = 0; k < map.size(); k++) {
            List<Integer> list = map.get(k);
            int curExample = k;
            // 当前用例已使用，跳过
            if(used[curExample]) continue;
            // 使用当前用例
            used[curExample] = true;
            set.add(curExample);
            // 覆盖模块
            boolean[] temp = Arrays.copyOf(coverCheck, j);//保存当前副本，后续回溯需要
            int tempCount = coverCount;
            for (int l = 0; l < j; l++) {
                // 判断当前用例是否能覆盖该模块
                if(list.contains(l)){
                    if(coverCheck[l]) continue;
                    coverCheck[l] = true;
                    coverCount++;
                }
            }
            dfs(coverCount);
            // 回溯
            used[curExample] = false;
            set.remove(set.size() - 1);
            coverCheck = temp;
            coverCount = tempCount;
        }
    }
}
