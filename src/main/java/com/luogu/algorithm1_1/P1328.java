package com.luogu.algorithm1_1;

import java.util.*;

class P1328{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int N_A = in.nextInt();
        int N_B = in.nextInt();
        //每种手势能赢过的手势
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //0 表示 剪刀，1 表示 石头，2 表示 布，3 表示 蜥蜴人，4 表示 斯波克
        map.put(0, new HashSet<Integer>());
        map.get(0).add(2);
        map.get(0).add(3);
        map.put(1, new HashSet<Integer>());
        map.get(1).add(0);
        map.get(1).add(3);
        map.put(2, new HashSet<Integer>());
        map.get(2).add(4);
        map.get(2).add(1);
        map.put(3, new HashSet<Integer>());
        map.get(3).add(4);
        map.get(3).add(2);
        map.put(4, new HashSet<Integer>());
        map.get(4).add(0);
        map.get(4).add(1);
        int[] guessA = new int[N_A];
        int[] guessB = new int[N_B];
        for(int i = 0; i < N_A; i++){
            guessA[i] = in.nextInt();
        }
        for(int i = 0; i < N_B; i++){
            guessB[i] = in.nextInt();
        }
        int scoreA = 0;
        int scoreB = 0;
        int indexA = 0;
        int indexB = 0;
        for(int i = 0; i < N; i++){
            int g_A = guessA[indexA];
            int g_B = guessB[indexB];
            if(g_A != g_B){
                if(map.get(g_A).contains(g_B)){
                    scoreA++;
                }else{
                    scoreB++;
                }
            }
            indexA = (indexA + 1) % N_A;
            indexB = (indexB + 1) % N_B;
        }
        System.out.print(scoreA);
        System.out.print(" " + scoreB);
    }
}
