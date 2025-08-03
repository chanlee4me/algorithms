package com.huawei;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class P3310 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] tempCars = in.nextLine().split(" ");
        int[] cars = new int[tempCars.length];
        if(tempCars.length < 1 || tempCars.length > 1000){
            System.out.println(-1);
            return;
        }
        Deque<Integer> carQueue = new LinkedList<>();
        for (int i = 0; i < tempCars.length; i++) {
            cars[i] = Integer.parseInt(tempCars[i]);
            if(cars[i] < 1 || cars[i] > 100){
                System.out.println(-1);
                return;
            }
            carQueue.addLast(cars[i]);
        }

        String[] tempGeneralRequires = in.nextLine().split(" ");
        int[] generalRequires = new int[tempGeneralRequires.length];
        if(tempGeneralRequires.length < 1 || tempGeneralRequires.length > 1000){
            System.out.println(-1);
            return;
        }
        Deque<Integer> generalQueue = new LinkedList<>();
        for (int i = 0; i < tempGeneralRequires.length; i++) {
            generalRequires[i] = Integer.parseInt(tempGeneralRequires[i]);
            if(generalRequires[i] < 1 || generalRequires[i] > 100){
                System.out.println(-1);
                return;
            }
            generalQueue.addLast(generalRequires[i]);
        }
        int step = 0;

        while(!carQueue.isEmpty() && !generalQueue.isEmpty() && step <= 50000){
            // 提供的粮食车数
            int foodSize = carQueue.removeFirst();
            int attempts = generalQueue.size();
            step++;

            for (int i = 0; i < attempts; i++) {
                // 需要的粮食车数
                int generalNeed = generalQueue.getFirst();
                if(foodSize >= generalNeed){
                    int sum = 0;
                    // 不断新纳入营区
                    while(!generalQueue.isEmpty() && sum + generalQueue.getFirst() <= foodSize){
                        sum += generalQueue.removeFirst();
                    }
                    break;
                }else{
                    generalQueue.addLast(generalQueue.removeFirst());
                }
            }
        }
        System.out.println(generalQueue.size());
    }
}

