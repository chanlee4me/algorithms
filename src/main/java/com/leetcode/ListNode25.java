package com.leetcode;

public class ListNode25 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
    }
    private static ListNode func(ListNode head, int k) {
        ListNode dummyHead = new ListNode();

        ListNode pre = dummyHead;
        ListNode end = head;
        ListNode start = null;
        while (end != null) {
            start = end;
            for (int i = 0; i < k - 1 && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            //end指向待翻转链表的当前尾部节点
            ListNode next = end.next;//未翻转部分的起始节点
            end.next = null;
            pre.next = reverse(start);
            //更新
            pre = start;
            end = next;
        }
            pre.next = start;
        return dummyHead.next;
    }
    private static ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode next =head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
