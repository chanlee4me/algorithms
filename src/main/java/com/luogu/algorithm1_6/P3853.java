package com.luogu.algorithm1_6;

import java.util.Scanner;

public class P3853 {
    static int l;   //公路的长度
    static int n;   //原有路标的数量
    static int k;   //最多可增设的路标数量
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        l = in.nextInt();
        n = in.nextInt();
        k = in.nextInt();
        int[] pos = new int[n];
        int last = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            pos[i] = in.nextInt();
            if(i != 0){
                int temp = pos[i] - last;
                index = Math.max(temp, index);
                last = pos[i];
            }
        }
        int left = 1;
        int right = index;
        int res = index;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(check(mid, pos) <= k){
                res = Math.min(res, mid);
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(res);
    }

    /**
     *
     * @param index 新的空旷指数
     * @param pos
     * @return
     */
    public static int check(int index, int[] pos){
        int last = 0;
        int count = 0;
        for (int i = 1; i < pos.length; i++) {
            if(pos[i] - last > index){//两个路标之间距离大于了空旷指数，需要新增路标
                //如果距离大于空旷指数的 2 倍，那么新增的路标数应该为：distance / index向上取整 - 1
                double temp = (double) (pos[i] - last) / index;
                int temp1 = (pos[i] - last) / index;
                if(temp1 < temp) temp1++;
                count += temp1 - 1;
            }
            last = pos[i];
        }
        return count;
    }
}
