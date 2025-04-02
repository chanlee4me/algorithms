package com.leetcode;

public class ListNode24 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
    }
    public static ListNode func(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode cur = head;
        ListNode pre = dummyHead;

        while(cur != null && cur.next != null){
            ListNode next = cur.next.next;
            ListNode tempNext = cur.next;
            pre.next = tempNext;
            tempNext.next = cur;
            cur.next = null; //防止出现环
            pre = cur;
            cur = next;
        }
        pre.next = cur;
        return dummyHead.next;
    }
}
