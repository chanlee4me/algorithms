package com.luogu.algorithm1_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P2089 {
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n < 10 || n > 30){
            System.out.print("0");
            return;
        }
        int[] arr = new int[10];
        backtrack(arr, 0, n);
        list.sort((arr1, arr2) ->{
            for (int i = 0; i < 10; i++) {
                if(arr1[i] != arr2[i])
                    return Integer.compare(arr1[i], arr2[i]);
            }
            return 0;
        });
        int size = list.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 10; j++) {
                if(j != 0)
                    System.out.print(" ");
                System.out.print(list.get(i)[j]);
            }
            if(i < size - 1)
                System.out.println("");

        }
    }
    public static void backtrack(int[] arr, int curIndex, int remain){
        int indexLeft = 10 - curIndex;
        if(remain < indexLeft || remain > indexLeft * 3) return;
        if(curIndex == 10){
            if(remain == 0){
                list.add(Arrays.copyOf(arr, 10));
            }
            return;
        }
        if(remain <= 0 || curIndex >= 10) return;
        for (int i = 1; i < 4 && i <= remain; i++) {
            arr[curIndex] = i;
            backtrack(arr, curIndex + 1, remain - i);
        }
    }
}
