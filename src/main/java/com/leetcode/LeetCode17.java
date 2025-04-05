package com.leetcode;

import java.util.*;

public class LeetCode17 {
    Map<Character, String> map = new HashMap<>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }};
    List<String> res = new ArrayList<>();
    List<String> letterCombinations(String digits){

        if(digits.length() == 0 || digits == null) return res;

        StringBuilder path = new StringBuilder();
        String s = map.get(digits.charAt(0));
        backtrack(digits, 0, path);
        return res;
    }
    void backtrack(String digits, int index, StringBuilder path){
        if(index >= digits.length()){
            res.add(path.toString());
            return;
        }
        String s = map.get(digits.charAt(index));
        for (int i = 0; i < s.length(); i++) {
            path.append(s.charAt(i));
            backtrack(digits, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode17 leetCode17 = new LeetCode17();
        String digits = "23";
        List<String > res = leetCode17.letterCombinations(digits);
    }
}
