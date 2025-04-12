package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode763 {
    public List<Integer> partitionLabels(String s) {
        //记录每个字符的最后出现位置
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c - 'a'] = i;
        }
        int start = 0;
        List<Integer> res = new ArrayList<>();
        while(start < s.length()){
            int edge = start;
            for (int i = start; i <= edge; i++) {
                char c = s.charAt(i);
                edge = Math.max(map[c - 'a'], edge);
            }
            res.add(edge - start + 1);
            start = edge + 1;
        }
        return res;
    }
}
