package com.luogu.algorithm1_4;

import java.util.Scanner;

public class P1259 {
    public static void main(String[] args) {
        /**
         * 学习分治法思想
         */
        String line1 = "oooo****--";
        String line2 = "ooo--***o*";
        String line3 = "ooo*o**--*";
        String line4 = "o--*o**oo*";
        String line5 = "o*o*o*--o*";
        String line6 = "--o*o*o*o*";
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //init
        char[] chess = new char[n * 2 + 2];
        for (int i = 0; i < chess.length; i++) {
            if(i < n){
                chess[i] = 'o';
            }else if(i >= n && i < 2 * n){
                chess[i] = '*';
            }else{
                chess[i] = '-';
            }
            System.out.print(chess[i]);
        }
        System.out.println();
        String tail = "";
        int oEdge = n - 1;
        int xEdge = 2 * n - 1;
        int sEdge = 2 * n + 1;
        while(n >= 4){
            if(n > 4){
                swap(chess, oEdge, sEdge - 1);
                swap(chess, oEdge + 1, sEdge);
                print(chess);
                System.out.println();
                oEdge--;
                swap(chess, oEdge + 1, xEdge - 1);
                swap(chess, oEdge + 2, xEdge);
                print(chess);
                System.out.println();
                xEdge -= 2;
                sEdge -= 2;
                tail += "o*";
                n--;
            }else{
                if(tail == null || tail.length() == 0){
                    print((line1 + tail).toCharArray());
                    System.out.println();
                }
                print((line2 + tail).toCharArray());
                System.out.println();
                print((line3 + tail).toCharArray());
                System.out.println();
                print((line4 + tail).toCharArray());
                System.out.println();
                print((line5 + tail).toCharArray());
                System.out.println();
                print((line6 + tail).toCharArray());
                break;
            }
        }
    }
    public static void swap(char[] arr, int i, int j){
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
    public static void print(char[] arr){
        for(char c : arr){
            System.out.print(c);
        }
    }
}
