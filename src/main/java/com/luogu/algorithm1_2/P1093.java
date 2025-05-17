package com.luogu.algorithm1_2;

import java.util.*;

public class P1093 {
    public static class Student{
        int id;
        Map<String, Integer> scores;
        int totalScore;
        int chineseScore;

        public Student(int id, Map<String, Integer> scores) {
            this.id = id;
            this.scores = scores;
            this.totalScore = scores.values().stream().mapToInt(Integer::intValue).sum();
            this.chineseScore = scores.getOrDefault("语文", 0); // 假设语文科目名称为 "语文"
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<Student> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            Map<String, Integer> scores = new HashMap<>();
            scores.put("语文", in.nextInt());
            scores.put("数学", in.nextInt());
            scores.put("英语", in.nextInt());
            Student student = new Student(i, scores);
            list.add(student);
        }

        list.sort(new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2) {
                // 1. 按总分降序排序
                if(s1.totalScore != s2.totalScore){
                    return Integer.compare(s2.totalScore, s1.totalScore);
                }
                // 2. 按语文降序排序
                if(s1.chineseScore != s2.chineseScore){
                    return Integer.compare(s2.chineseScore, s1.chineseScore);
                }
                // 3. 按学号升序排序
                return Integer.compare(s1.id, s2.id);
            }
        });

        for (int i = 0; i < 5; i++) {
            Student student = list.get(i);
            if(i < 4)
                System.out.println(student.id + " " + student.totalScore);
            else
                System.out.print(student.id + " " + student.totalScore);
        }
    }
}

