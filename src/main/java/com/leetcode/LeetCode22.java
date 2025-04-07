package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, "");
        return res;
    }
    public void dfs(int n, int left, int right, String s){
        if(left > n || right > left) return;
        if(left == right && left == n){
            res.add(new String(s));
            return;
        }
        dfs(n, left + 1, right, s + '(');
        dfs(n, left, right + 1, s + ')');
    }

    public static void main(String[] args) {
        LeetCode22 lc = new LeetCode22();
        int n = 3;
        lc.generateParenthesis(n);
        for (int i = 0; i < lc.res.size(); i++) {
            System.out.println(lc.res.get(i));
        }
    }
}
