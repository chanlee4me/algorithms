package com.luogu.algorithm1_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class P4447{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = in.nextInt();
        }
        List<Integer> valueList = new ArrayList<>();
        Arrays.sort(value);
        for (int i = 0; i < n; i++) {
            if(i != 0 && value[i] == value[i - 1]){
                continue;
            }
            valueList.add(value[i]);
        }
        int curLength = 1;
        List<Integer> lengthList = new ArrayList<>();
        for (int i = 1; i < valueList.size(); i++) {
            if(valueList.get(i - 1) + 1 == valueList.get(i)){
                curLength++;
            }else{
                lengthList.add(curLength);
                curLength = 1;
            }
        }
        lengthList.add(curLength);
        int minLength = lengthList.get(0);
        for (int i = 1; i < lengthList.size(); i++) {
            minLength = Math.min(lengthList.get(i), minLength);
        }
        System.out.println(minLength);
    }
}