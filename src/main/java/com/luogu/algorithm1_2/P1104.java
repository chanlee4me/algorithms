package com.luogu.algorithm1_2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P1104 {
    static class Person{
        String name;
        int year;
        int month;
        int day;
        int num;

        public Person(String name, int year, int month, int day, int num) {
            this.year = year;
            this.day = day;
            this.month = month;
            this.name = name;
            this.num = num;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Person[] arr = new Person[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Person(in.next(), in.nextInt(), in.nextInt(), in.nextInt(), i);
        }

        Arrays.sort(arr, (a, b) ->{
            if(a.year != b.year){
                return Integer.compare(a.year, b.year);
            }
            if(a.month != b.month){
                return Integer.compare(a.month, b.month);
            }
            if(a.day != b.day)
                return Integer.compare(a.day, b.day);
            return Integer.compare(b.num, a.num);
        });

        for (int i = 0; i < n; i++) {
            if(i < n -1)
                System.out.println(arr[i].name);
            else
                System.out.print(arr[i].name);
        }
    }
}
