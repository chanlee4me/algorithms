package com.luogu.algorithm1_6;

import java.util.Scanner;

public class P2678 {
    static int l;
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        l = in.nextInt();   //起点和终点的距离
        n = in.nextInt();   //起点和终点之间的岩石数
        m = in. nextInt();  //至多移动的岩石数
        int[] pos = new int[n + 2];    //第 i 块岩石与起点的距离
        pos[0] = 0;
        pos[n + 1] = l;
        for (int i = 1; i < n + 1; i++) {
            pos[i] = in.nextInt();
        }
        int left = 1;
        int right = l;
        int res = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(check(mid, pos) <= m){
                res = Math.max(res, mid);
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(res);
    }
    public static int check(int d, int[] pos){
        int last = 0;
        int remove = 0;
        for (int i = 1; i < pos.length - 1; i++) {
            if(pos[i] - last < d){
                remove++;
            }else{
                last = pos[i];
            }
        }
        if(l - last < d)  remove++;
        return remove;
    }
}
