package com.luogu.algorithm1_7;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P2036 {
    public static int res = Integer.MAX_VALUE;
    public static int n;
    public static int[] s;
    public static int[] k;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        s = new int[n];
        k = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.nextInt();
            k[i] = in.nextInt();
        }
        dfs(0, 1, 0, false);
        System.out.print(res);
    }

    /**
     *
     * @param index     当前配料索引
     * @param s_all     总酸度乘积
     * @param k_all     总苦度和
     * @param picked    是否选择了至少一个配料
     */
    public static void dfs(int index, int s_all, int k_all, boolean picked){
        if(index == n){
            if(picked){
                res = Math.min(Math.abs(k_all - s_all), res);
            }
            return;
        }
        int new_s_all = s_all * s[index];
        int new_k_all = k_all + k[index];

        //选择当前配料
        dfs(index + 1, new_s_all, new_k_all, true);
        //不选择当前配料
        dfs(index + 1, s_all, k_all, picked);
    }
}
