package com.leetcode;

public class LeetCode76 {
    public String minWindow(String s, String t) {
        int[] window = new int[128];
        int leftRes = -1;
        int rightRes = s.length();
        //init
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            window[s.charAt(right)]++;
            while(isCover(need, window)){//刚好包含 t 字符串，开始收缩
                if(right - left < rightRes - leftRes){
                    rightRes = right;
                    leftRes = left;
                }
                window[s.charAt(left)]--;
                left++;
            }
        }
        if(leftRes < 0) return "";
        else return s.substring(leftRes, rightRes + 1);
    }
    private boolean isCover(int[] need, int[] window){
        for (int i = 'a'; i <= 'z'; i++) {
            if(need[i] > window[i]) return false;
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            if(need[i] > window[i]) return false;
        }
        return true;
    }
}
