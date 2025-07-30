package com.huawei;

import java.util.Enumeration;
import java.util.Scanner;

public class P3304 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] pvs = new int[n];
        for (int i = 0; i < n; i++) {
            pvs[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if(pvs[i] == 1) {
                int flag = 0;
                // 优先在右侧安装
                if (i + 1 < n && pvs[i + 1] == 0) {
                    pvs[i + 1] = 3;
                    pvs[i] = 2;
                    if (i + 2 < n && pvs[i + 2] == 1) pvs[i + 2] = 2;
                    flag = 1;
                } else if (i - 1 >= 0 && pvs[i - 1] == 0) {
                    // 在左侧安装
                    pvs[i - 1] = 3;
                    pvs[i] = 2;
                    flag = 1;
                }
                if (flag == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if(pvs[i] == 3) res++;
        }
        System.out.println(res);
    }
}
