package com.leetcode;

public class ListNode148 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
    }
    private static ListNode sortList(ListNode head){
        if(head == null || head.next == null) return head;
        //找到中点
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;//切割
        //递归排序
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        //合并
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while(left != null && right != null){
            if(left.val < right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if(left != null) cur.next = left;
        if(right != null) cur.next = right;

        return dummyHead.next;
    }
}
