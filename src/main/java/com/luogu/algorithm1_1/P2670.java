package com.luogu.algorithm1_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class P2670{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();//make sure the after input works;
        List<String> map = new ArrayList<>();
        for(int i = 0; i < n; i++){
            map.add(in.nextLine());
        }
        for(int j = 0; j < n; j++){
            String row = map.get(j);
            for(int i = 0; i < m; i++){
                if(row.charAt(i) == '*'){
                    System.out.printf("*");
                }else{
                    System.out.print(getNearBombCount(map, j, i));
                }
            }
            if(j != n - 1)
                System.out.println("");
        }
    }
    private static int getNearBombCount(List<String> map, int row, int col){
        int count = 0;
        int n = map.size();//n 行
        int m = map.get(0).length(); //m 列
        if(row - 1 >= 0 && map.get(row - 1).charAt(col) == '*') count++;
        if(row - 1 >= 0 && col - 1 >= 0 && map.get(row - 1).charAt(col - 1) == '*') count++;
        if(row - 1 >= 0 && col + 1 < m && map.get(row - 1).charAt(col + 1) == '*') count++;
        if(col - 1 >= 0 && map.get(row).charAt(col - 1) == '*') count++;
        if(col + 1 < m && map.get(row).charAt(col + 1) == '*') count++;
        if(row + 1 < n && col - 1 >= 0 && map.get(row + 1).charAt(col - 1) == '*') count++;
        if(row + 1 < n && col + 1 < m && map.get(row + 1).charAt(col + 1) == '*') count++;
        if(row + 1 < n && map.get(row + 1).charAt(col) == '*') count++;

        return count;

    }
}