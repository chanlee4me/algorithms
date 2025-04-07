package com.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class LeetCode131 {
    LinkedList<LinkedList<String>> res = new LinkedList<>();
    public LinkedList<LinkedList<String>> partition(String s) {
        dfs(s, 0, new LinkedList<>());
        return res;
    }
    public void dfs(String s, int start, LinkedList<String> path){
        if(start >= s.length()){
            res.addLast(new LinkedList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(isValid(s, start, i)){
                path.addLast(s.substring(start, i + 1));
                dfs(s, i + 1, path);
                path.removeLast();
            }
        }
    }
    public boolean isValid(String s, int start, int end){
        if(start > end || end >= s.length()) return false;
        if(end - start <= 2){
            if(s.charAt(end) == s.charAt(start)) return true;
            else return false;
        }else{
            while(start <= end){
                if(s.charAt(end) == s.charAt(start)){
                    start++;
                    end--;
                }else{
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        LeetCode131 lc = new LeetCode131();
        String s = "abbab";
        lc.partition(s);
        for (int i = 0; i < lc.res.size(); i++) {
            System.out.println(lc.res.get(i));
        }

    }
}
