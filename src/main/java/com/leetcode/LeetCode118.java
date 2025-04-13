package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i){
                    row.add(j, 1);
                }else{
                    List<Integer> preRow = list.get(i - 1);//上一行
                    row.add(j, preRow.get(j - 1) + preRow.get(j));
                }
            }
            list.add(new ArrayList<>(row));
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> triangle = new LeetCode118().generate(n);
        System.out.println(triangle.toArray());
    }
}
