package com.leetcode;

import java.util.*;

public class LeetCode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];//记录每门课程的入度：即前置课程数
        //记录每门课的后置课程
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        //利用 BFS（层次遍历）的方式来学习
        int learnedCount = 0;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) queue.addLast(i);
        }
        while(!queue.isEmpty()){
            int size = 0;
            for (int i = 0; i < size; i++) {
                int learnedCourse = queue.removeFirst();
                learnedCount++;
                //将当前学习课程的后置课程的入度减少，当入度为 0 时入队
                List<Integer> list = map.get(learnedCourse);
                for (int j = 0; j < list.size(); j++) {
                    int course = list.get(j);
                    indegree[course]--;
                    if(indegree[course] == 0) queue.addLast(course);
                }
            }
        }
        return learnedCount == numCourses;
    }
}
