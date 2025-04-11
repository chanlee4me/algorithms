package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode84 {
    public int largestRectangleArea(int[] heights) {
        //以每个柱子为基准，记录右侧第一个比他小的柱子的左侧柱子
        Deque<Integer> stack = new LinkedList<>();
        int length = heights.length;

        stack.addLast(0);
        int maxArea = 0;
        for (int i = 0; i <= length; i++) {
            int h = (i == length) ? 0 : heights[i];//添加个哨兵，防止在循环结束时栈不为空
            //每次出栈时，栈顶和 i 分别就是左/右侧矮于它的柱子高度
            while (!stack.isEmpty() && h < heights[stack.getLast()]) {
                int height = heights[stack.removeLast()];
                //栈为空说明左侧全是比它高的柱子，则宽度就是 i
                int width = stack.isEmpty() ? i : i - stack.getLast() - 1;
                maxArea = Math.max(height * width, maxArea);
            }
            stack.addLast(i);
        }
        return maxArea;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 4};
        LeetCode84 solution = new LeetCode84();
        solution.largestRectangleArea(arr);
    }
}