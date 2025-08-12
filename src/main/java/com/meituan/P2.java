package com.meituan;

import java.util.Scanner;
//2024年春招-美团-技术岗-第一批笔试-第二题
// 耗时10分钟，通过：ALL
public class P2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int q = in.nextInt();

        in.nextLine();
        String[] strings = in.nextLine().split(" ");

        int[] array = new int[n];
        long ori_sum = 0;
        int random_count = 0;
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(strings[i]);
            ori_sum += array[i];
            if(array[i] == 0) random_count++;
        }

        for (int i = 0; i < q; i++) {
            long l = in.nextLong();
            long r = in.nextLong();
            long minSum = ori_sum + l * random_count;
            long maxSum = ori_sum + r * random_count;
            System.out.println(minSum + " " + maxSum);
        }

    }
}
