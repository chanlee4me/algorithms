package com.luogu.algorithm1_5;

import java.util.Arrays;
import java.util.Scanner;

public class P1094 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int n = in.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = in.nextInt();
        }
        Arrays.sort(price);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(price[i] == 0) continue;
            else if(price[i] > w){
                price[i] = 0;
                count++;
            }else{
                int flag = 0;
                for (int j = n - 1; j >= 0; j--) {
                    if(price[j] != 0 && i != j && price[i] + price[j] <= w){
                        price[i] = 0;
                        price[j] = 0;
                        count++;
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0) {//说明没凑成组，那么单独成组
                    price[i] = 0;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
