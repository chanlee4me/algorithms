package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode38 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> path = new LinkedList<>();
        dfs(candidates, target, 0, 0, path);
        return res;
    }
    public void dfs(int[] candidates, int target, int startIndex, int sum, LinkedList<Integer> path){
        if(sum >= target){
            if(sum == target) res.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            dfs(candidates, target, i, sum + candidates[i], path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        LeetCode38 lc = new LeetCode38();
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> result = lc.combinationSum(candidates, target);
    }
}
