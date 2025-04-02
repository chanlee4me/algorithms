package com.leetcode;

public class ListNode206 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    /**
     * 翻转链表
     * @param head 头节点
     * @return
     */
    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
