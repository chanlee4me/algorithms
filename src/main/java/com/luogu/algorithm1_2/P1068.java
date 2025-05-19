package com.luogu.algorithm1_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 需要我设定进面试的分数线：进面人数为录取人数的 150% ，设为 x
 * 那么对所有人排序，取前x个人
 * 因为可能有多人同样得分，所以以第 x 人的分数作为分数线，再往后录取同样分数的人
 */
//解法一：快速排序
public class P1068 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{in.nextInt(), in.nextInt()});
        }
        Collections.sort(list, (a, b) ->{
            if(a[1] != b[1]){
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int x = (int)(m * 1.5); //排名第 rank 的选手作为分数线
        int scoreLine = list.get(x - 1)[1];
        int rank = x;
        for (int i = rank ; i < n; i++) {
            if(list.get(i)[1] == scoreLine){
                rank++;
            }else{
                break;
            }
        }
        //输出
        System.out.println(scoreLine + " " + rank);
        for (int i = 0; i < rank; i++) {
            if(i < rank - 1)
                System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
            else
                System.out.print(list.get(i)[0] + " " + list.get(i)[1]);
        }
    }
}
