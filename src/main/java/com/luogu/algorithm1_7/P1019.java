package com.luogu.algorithm1_7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1019 {
    // 记录每个单词的使用次数
    public static Map<String, Integer> usedCount;
    public static int res = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        String[] words = new String[n];
        usedCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            words[i] = in.nextLine();
            usedCount.putIfAbsent(words[i], 0);
        }

        String start = in.nextLine();

        // 选取开头的字符串进行接龙
        for(String s : words) {
            if(s.charAt(0) == start.charAt(0)){
                usedCount.put(s, usedCount.get(s) + 1);
                dfs(words, s, s);
                usedCount.put(s, usedCount.get(s) - 1);
            }
        }
        System.out.println(res);
    }

    /**
     *
     * @param words 存储单词的数组
     * @param dragon 接的龙
     */
    public static void dfs(String[] words, String dragon, String preWord){
        // 更新长度
        res = Math.max(res, dragon.length());
        for(String s : words){
            // 不能存在包含关系
            if(!isContain(s, preWord) && !isContain(preWord, s) && usedCount.get(s) < 2){
                // 判断能否接龙
                int mergeLength = 0;
                // 用 i 表示重合的长度
                for (int i = 1; i < Math.min(preWord.length(), s.length()); i++) {
                    if(preWord.endsWith(s.substring(0, i))){
                        mergeLength = i;
                        break;
                    }
                }
                // 能够接龙
                if(mergeLength != 0){
                    // 使用次数+1
                    usedCount.put(s, usedCount.get(s) + 1);
                    // 接龙
                    dfs(words, dragon + s.substring(mergeLength), s);
                    usedCount.put(s, usedCount.get(s) - 1);
                }

            }
        }
    }

    // 检验两个字符串是否是包含关系
    private static boolean isContain(String dragon, String s){
         if(dragon.length() != s.length() && dragon.contains(s)){
             return true;
         }
         return false;
    }
}
