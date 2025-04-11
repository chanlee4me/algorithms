package com.leetcode;


import java.util.LinkedList;
import java.util.List;

public class LeetCode155 {
    class MinStack{
        //数组第一个元素存储栈中的值，第二个元素记录该值入栈时栈中的最小值
        LinkedList<int []> stack = new LinkedList<>();
        void push(int val){
            if(stack.isEmpty()){
                stack.addLast(new int[]{val, val});
            }else{
                //入栈时的最小元素
                int minVal = Math.min(stack.getLast()[1], val);
                stack.addLast(new int[]{val, minVal});
            }
        }
        int top(){
            return stack.getLast()[0];
        }
        void pop(){
            stack.removeLast();
        }
        int getMin(){
            return stack.getLast()[1];
        }
    }

}
