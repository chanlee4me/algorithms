package com.luogu.algorithm1_1;

import java.util.*;

class P1042{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while(in.hasNextLine()){
            input.add(in.nextLine());
        }
        //11
        int round = 0;
        int win = 0;
        int lose = 0;
        List<int[]> res_11 = new ArrayList<>();
        for(String s : input){
            for(int i = 0; i < s.length(); i++){
                round++;
                if(s.charAt(i) == 'W') win++;
                if(s.charAt(i) == 'L') lose++;
                if((Math.max(win, lose) >= 11 && Math.abs(win -lose) >= 2) || s.charAt(i) == 'E'){
                    res_11.add(new int[]{win, lose});
                    win = 0;
                    lose = 0;
                    round = 0;
                }
                if(s.charAt(i) == 'E'){
                    round = -1;
                    break;
                }
            }
            if(round == -1) break;
        }
        //21
        round = 0;
        win = 0;
        lose = 0;
        List<int[]> res_21 = new ArrayList<>();
        for(String s : input){
            for(int i = 0; i < s.length(); i++){
                round++;
                if(s.charAt(i) == 'W') win++;
                if(s.charAt(i) == 'L') lose++;
                if((Math.max(win, lose) >= 21 && Math.abs(win -lose) >= 2) || s.charAt(i) == 'E'){
                    res_21.add(new int[]{win, lose});
                    win = 0;
                    lose = 0;
                    round = 0;
                }
                if(s.charAt(i) == 'E'){
                    round = -1;
                    break;
                }
            }
            if(round == -1) break;
        }

        //print
        for(int[] score : res_11){
            System.out.println(score[0] + ":" + score[1]);
        }
        System.out.println("");
        for(int i = 0; i < res_21.size(); i++){

            if(i == res_21.size() - 1){
                System.out.printf(res_21.get(i)[0] + ":" + res_21.get(i)[1]);
            }
            else
                System.out.println(res_21.get(i)[0] + ":" + res_21.get(i)[1]);
        }
    }
}