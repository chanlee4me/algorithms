package com.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode394 {
    class Solution {
        public String decodeString(String s) {
            Deque<String> numStack = new LinkedList<>();
            Deque<String> strStack = new LinkedList<>();
            StringBuilder numStr = new StringBuilder();
            StringBuilder alphabetStr = new StringBuilder();
            for(char c : s.toCharArray()){
                if(c == '['){
                    numStack.addLast(numStr.toString());
                    strStack.addLast(alphabetStr.toString());
                    alphabetStr.delete(0, alphabetStr.length());
                    numStr.delete(0, numStr.length());
                }else if(c == ']'){
                    int num = Integer.parseInt(numStack.removeLast());
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < num; i++) {
                        sb.append(alphabetStr);
                    }
                    alphabetStr = new StringBuilder(strStack.removeLast()).append(sb);
                }else if(isDigital(c)){
                    numStr.append(c);
                }else{//字母
                    alphabetStr.append(c);
                }
            }
            return alphabetStr.toString();
        }
        public boolean isDigital(char c){
            if(c - '0' >= 0 && c - '9' <= 0) return true;
            else return false;
        }
    }
}
