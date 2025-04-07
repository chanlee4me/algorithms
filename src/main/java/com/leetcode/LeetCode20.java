package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode20 {
    public boolean isValid(String s){
        if(s.length() % 2 != 0) return false;

        Deque<Character> queue = new LinkedList<>();

        int curIndex = 0;
        char c = s.charAt(curIndex++);
        if(c == ')' || c == ']' || c == '}') return false;
        queue.addLast(c);

        while(curIndex < s.length()){
            c = s.charAt(curIndex++);
            if(c == '(' || c == '[' || c == '{') {
                queue.addLast(c);
            }else if(c == ')'){
                if(queue.isEmpty()) return false;
                if(queue.removeLast() != '('){
                    return false;
                }
            }else if(c == ']'){
                if(queue.isEmpty()) return false;
                if(queue.removeLast() != '['){
                    return false;
                }
            }else if(c == '}'){
                if(queue.isEmpty()) return false;
                if(queue.removeLast() != '{'){
                    return false;
                }
            }
        }
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode20 leetCode20 = new LeetCode20();
        String s = "(){}}{";
        leetCode20.isValid(s);
    }
}
