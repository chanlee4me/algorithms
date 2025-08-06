package com.huawei;

import java.util.*;

public class P3312 {
    public static List<int[]> sensor_events;
    // 记录每个传感器的激活时间
    public static Map<Integer, List<Integer>> map;
    public static void main(String[] args) {
        // init
        Scanner in = new Scanner(System.in);
        map = new TreeMap<>();
        sensor_events = new ArrayList<>();

        while(in.hasNextLine()){
            String line = in.nextLine();
            if(line.equals("")) break;
            String[] strings = line.split(" ");
            int id = Integer.parseInt(strings[0]);
            int time = Integer.parseInt(strings[1]);
            sensor_events.add(new int[]{id, time});
        }
        in.close();

        // core
        int preTime = 0;
        for (int i = 0; i < sensor_events.size(); i++) {
            int curId = sensor_events.get(i)[0];
            int curTime = sensor_events.get(i)[1];
            // 更新当前传感器的激活时间
            map.putIfAbsent(curId, new ArrayList<>());
            map.get(curId).add(curTime - preTime);
            // 更新变量值
            preTime = curTime;
        }
        // 找到激活时间最短和最长的传感器
        int minTimeId = -1;
        int minTime = Integer.MAX_VALUE;
        int maxTimeId = -1;
        int maxTime = 1;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            int id = entry.getKey();
            List<Integer> timeList = entry.getValue();
            if(minTimeId == -1 && maxTimeId == -1){
                minTimeId = id;
                maxTimeId = id;
                for(int time : timeList){
                    if(maxTime == -1 && minTime == -1){
                        maxTime = time;
                        minTime = time;
                    }else{
                        maxTime = Math.max(time, maxTime);
                        minTime = Math.min(time, minTime);
                    }
                }
            }else{
                for(int time : timeList){
                    if(time < minTime){
                        minTimeId = id;
                        minTime = time;
                    }
                    if (time > maxTime) {
                        maxTimeId = id;
                        maxTime = time;
                    }
                    if(time == minTime && id < minTimeId) {
                        minTimeId = id;
                    }
                    if (time == maxTime && id < maxTimeId) {
                        maxTimeId = id;
                    }
                }
            }
        }
        System.out.println(minTimeId + " " + maxTimeId);
    }
}
