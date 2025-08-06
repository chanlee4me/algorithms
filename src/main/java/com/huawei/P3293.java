package com.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P3293 {
    public static String NONE = "None";
    public static List<int[]> versions;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        versions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] temp = in.nextLine().split("\\.");
            int size = temp.length;
            if(size == 1){
                versions.add(new int[]{Integer.parseInt(temp[0]), 0, 0});
            }
            if(size == 2){
                versions.add(new int[]{Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), 0});
            }
            if(size == 3){
                versions.add(new int[]{Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2])});
            }
        }
        // 将 list 按照 major minor patch 从小到大的顺序排列
        Collections.sort(versions, (a, b) ->{
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        String line = in.nextLine();
        if(line.charAt(0) == '*') {
            func1(new int[]{});
            return;
        }
        String temp = line.substring(1);
        String[] tempArray = temp.split("\\.");
        int size = tempArray.length;
        int[] array = new int[3];
        if(size == 1){
            array[0] = Integer.parseInt(tempArray[0]);
        }
        if(size == 2){
            array[0] = Integer.parseInt(tempArray[0]);
            array[1] = Integer.parseInt(tempArray[1]);
        }
        if(size == 3){
            array[0] = Integer.parseInt(tempArray[0]);
            array[1] = Integer.parseInt(tempArray[1]);
            array[2] = Integer.parseInt(tempArray[2]);
        }
        if(line.charAt(0) == '^') func2(array);
        else func3(array);
    }
    // 为*类型
    public static void func1(int[] target){
        int[] version = versions.get(versions.size() - 1);
        print(version);
//        System.out.println(version[0] + "." + version[1] + "." + version[2]);
    }
    // 找到第一个大于或者等于^x.y.z的所在位置
    public static int helper(int[] target){
        int left = 0, right = versions.size() - 1;
        int major = target[0];
        int minor = target[1];
        int patch = target[2];
        int pos = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right -left) / 2;
            if(versions.get(mid)[0] < major){
                left = mid + 1;
            }else if(versions.get(mid)[1] < minor){
                left = mid + 1;
            }else if(versions.get(mid)[2] < patch){
                left = mid + 1;
            }else{
                right = mid - 1;
                pos = Math.min(pos, mid);
            }
        }
        return pos == Integer.MAX_VALUE ? -1 : pos;
    }
    // 为^x.y.z类型 （取major版本一致情况下的最大版本）
    public static void func2(int[] target){

        int leftEdge = helper(target);
        if(leftEdge == -1){
            System.out.println(NONE);
            return;
        }
        int major = target[0];
        boolean flag = false;
        // 找到 major 后，继续向右寻找，直到找到最右侧的 major
        int left = leftEdge, right = versions.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int val = versions.get(mid)[0];
            if(val <= major){
                left = mid + 1;
                if(val == major) flag = true;
            }else {
                right = mid - 1;
            }
        }
        if(!flag){
            System.out.println(NONE);
            return;
        }
        int[] version = versions.get(left - 1);
//        System.out.println(version[0] + "." + version[1] + "." + version[2]);
        print(version);
    }
    // 为~x.y.z类型 或 -x.y.z（保证major和minor版本一致，只取最新的patch版本）
    public static void func3(int[] target){
        int leftEdge = helper(target);
        if(leftEdge == -1){
            System.out.println(NONE);
            return;
        }
        // 先找到 major 的区间
        int major = target[0];
        boolean flag = false;
        // 找 major 的右边界
        int majorRightEdge = -1;
        int left = leftEdge, right = versions.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int val = versions.get(mid)[0];
            if(val <= major){
                left = mid + 1;
                if(val == major) {
                    majorRightEdge = mid;
                    flag = true;
                }
            }else{
                right = mid - 1;
            }
        }
        if(!flag){
            System.out.println(NONE);
            return;
        }


        // 找 major 的左边界
        flag = false;
        int majorLeftEdge = -1;

        left = leftEdge; right = majorRightEdge;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int val = versions.get(mid)[0];
            if(val < major){
                left = mid + 1;
            }else {
                right = mid - 1;
                if(val == major) {
                    flag = true;
                    majorLeftEdge = mid;
                }
            }
        }
        if(!flag){
            System.out.println(NONE);
            return;
        }

        flag = false;

        // 在 major 的区间中找到 minor 的区间
        int minor = target[1];
        // 找 minor 的右边界
        int minorRightEdge = -1;
        left = majorLeftEdge; right = majorRightEdge;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int val = versions.get(mid)[1];
            if(val <= minor){
                left = mid + 1;
                if(val == minor) {
                    flag =true;
                    minorRightEdge = mid;
                }
            }else{
                right = mid - 1;
            }
        }
        if(!flag){
            System.out.println(NONE);
            return;
        }

        // 然后再在 minor 的区间中找到最新的 patch
        int[] version = versions.get(minorRightEdge);
        print(version);
    }
    public static void print(int[] version){
        if(version[2] == 0 && version[1] != 0){
            System.out.println(version[0] + "." + version[1]);
        }else if(version[2] == 0 && version[1] == 0){
            System.out.println(version[0]);
        }else{
            System.out.println(version[0] + "." + version[1] + "." + version[2]);
        }
    }
}
