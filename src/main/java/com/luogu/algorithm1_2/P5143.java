package com.luogu.algorithm1_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class P5143 {
    static class Pos{
        int x;
        int y;
        int z;
        Pos(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Pos> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Pos pos = new Pos(in.nextInt(), in.nextInt(), in.nextInt());
            list.add(pos);
        }
        Collections.sort(list, (a, b) ->{
            if(a.z != b.z){
                return Integer.compare(a.z, b.z);
            }
            if(a.x != a.x){
                return Integer.compare(a.x, b.x);
            }
            return Integer.compare(a.y, b.y);
        });

        double sum = 0;
        for (int i = 1; i < n; i++) {
            Pos cur = list.get(i);
            Pos prev = list.get(i - 1);
            double diff = compute(cur, prev);
            sum += diff;
        }
        System.out.printf("%.3f", sum);
    }
    public static double compute(Pos a, Pos b){
        int diffX = (a.x - b.x) * (a.x - b.x);
        int diffY = (a.y - b.y) * (a.y - b.y);
        int diffZ = (a.z - b.z) * (a.z - b.z);
        return Math.sqrt(diffX + diffY + diffZ);
    }
}

