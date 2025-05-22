package com.luogu.algorithm1_3;

import java.util.Scanner;

public class P1036 {
    static int res = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int k = in.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        boolean[] used = new boolean[n];
        backtrack(arr, k, 0, 0, used);
        System.out.print(res);
    }
    public static void backtrack(int[] arr, int k, int index, int count, boolean[] used){
        if(count == k){
            int sum = 0;
            for (int i = 0; i < used.length; i++) {
                if(used[i])
                    sum += arr[i];
            }
            if(isPrime(sum)) res++;
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if(used[i]) continue;
            used[i] = true;
            backtrack(arr, k,  i + 1,count + 1, used);
            used[i] = false;
        }
    }

    public static boolean isPrime(int number) {
        // Numbers less than or equal to 1 are not prime
        if (number <= 1) {
            return false;
        }

        // Check divisors from 2 up to the square root of the number
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
