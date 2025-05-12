package com.luogu.algorithm1_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 按照指定顺序将小人存放在数组中，并记录朝向-->用 List<int[]>存储
 根据指令来确定下一个小人位置
 **/
class P1563{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//小人个数
        int m = in.nextInt();//指令条数
        in.nextLine();//消耗回车

        //pos0:朝向 pos1:小人职业
        List<String []> people = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String[] strs = in.nextLine().split(" ");
            people.add(new String[]{strs[0], strs[1]});
        }
        Collections.reverse(people);
        int curPos = people.size() - 1;
        for(int i = 0; i < m; i++){
            int direct = in.nextInt();
            int step = in.nextInt();
            if(i < m - 1) {
                in.nextLine();//消耗回车
            }
            curPos = move(people, curPos, direct, step);
        }
        System.out.print(people.get(curPos)[1]);
    }
    public static int move(List<String []> people, int curPos, int direct, int step){
        //0 表示向左
        //0 表示朝内
        //面朝圈内的玩具小人，它的左边是顺时针方向
        //面向圈外的玩具小人，它的左边是逆时针方向

        //确定逆时针还是顺时针
        int flag = 0; // 1 表示逆时针，2 表示顺时针
        if(people.get(curPos)[0].equals("0")){//朝内
            if(direct == 0) flag = 2;
            else flag = 1;
        }else{
            if(direct == 0) flag = 1;
            else flag = 2;
        }

        if(flag == 2){
            return (curPos + step) % people.size();
        }else{
            if(curPos - step < 0){
                int temp = curPos - step;
                return people.size() + temp;
            }else {
                return  (curPos - step) % people.size();
            }
        }
    }
}