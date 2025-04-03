package com.leetcode;



public class LeetCode208 {

    class TrieNode{
        boolean isEnd;
        TrieNode[] next;
        TrieNode(){
            isEnd = false;
            next = new TrieNode[26];
        }
    }
    TrieNode root;
    public LeetCode208() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.next[c - 'a'] == null){
                cur.next[c - 'a'] = new TrieNode();
            }
            cur = cur.next[c - 'a'];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.next[c - 'a'] == null) return false;
            cur = cur.next[c - 'a'];
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur =root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.next[c - 'a'] == null) return false;
            cur = cur.next[c - 'a'];
        }
        return true;
    }
}
