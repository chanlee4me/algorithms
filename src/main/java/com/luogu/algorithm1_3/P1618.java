package com.luogu.algorithm1_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P1618 {
    static List<int[]> list = new ArrayList<>();
    static int[] array = new int[3];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        array[0] = in.nextInt();
        array[1] = in.nextInt();
        array[2] = in.nextInt();
        Arrays.sort(array);

        int[] arr = new int[9];
        boolean[] used = new boolean[9];
        backtrack(arr, used, 0);
        list.sort((a, b) ->{
            for (int i = 0; i < 3; i++) {
                if(a[i] != b[i]){
                    return Integer.compare(a[i], b[i]);
                }
            }
            return 0;
        });
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 3; j++) {
                if(j != 0)
                    System.out.print(" ");
                System.out.print(list.get(i)[j]);
            }
            if(i < size - 1)
                System.out.println("");
        }
        if(size == 0)
            System.out.print("No!!!");
    }

    public static void backtrack(int[] arr, boolean[] used, int count){
        if(count == 9){
            int numA = Integer.parseInt(new String(arr[0] + "" + arr[1] + "" + arr[2]));
            int numB = Integer.parseInt(new String(arr[3] + "" + arr[4] + "" + arr[5]));
            int numC = Integer.parseInt(new String(arr[6] + "" + arr[7] + "" + arr[8]));
            int[] temp = new int[]{numA, numB, numC};
            Arrays.sort(temp);
            if((double)numB / numA == (double)array[1] / array[0] && (double)numC / numB == (double)array[2] / array[1]){
                list.add(Arrays.copyOf(temp, 3));
            }
        }
        for (int i = 0; i < 9; i++) {
            if(used[i]) continue;
            arr[count] = i + 1;
            used[i] = true;
            backtrack(arr, used, count + 1);
            used[i] = false;
        }
    }
}
