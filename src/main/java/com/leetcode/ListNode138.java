package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ListNode138 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode random;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode node){
            this.val = val;
            this.next = node;
        }
    }
    private static ListNode func(ListNode head){
        //记录每个节点和复制节点的映射关系
        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode cur = head;
        while(cur != null){
            map.put(cur, new ListNode(cur.val));
            cur = cur.next;
        }
        //更新复制节点的random 指针
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
