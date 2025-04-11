package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode739 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> stack = new LinkedList<>();//存索引
            int[] res = new int[temperatures.length];
            stack.addLast(0);
            for (int i = 1; i < temperatures.length; i++) {
                while(!stack.isEmpty() && temperatures[i] > temperatures[stack.getLast()]){
                    int topIndex = stack.removeLast();
                    res[topIndex] = i - topIndex;
                }
                stack.addLast(i);
            }
            return res;
        }
    }
}
