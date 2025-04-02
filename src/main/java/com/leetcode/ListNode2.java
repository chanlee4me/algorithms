package com.leetcode;

public class ListNode2 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * 两数相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //新建一个链表作为基准链表，将相加后的链表存到他这里
        ListNode dummyHead = new ListNode();
        ListNode base = dummyHead;
        //从 l1、l2开始相加
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            int remain = sum % 10;
            base.next = new ListNode(remain);
            base = base.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val + carry;
            carry = sum / 10;
            int remain = sum % 10;
            base.next = new ListNode(remain);
            base = base.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int sum = l2.val + carry;
            carry = sum / 10;
            int remain = sum % 10;
            base.next = new ListNode(remain);
            base = base.next;
            l2 = l2.next;
        }
        if(carry != 0)
            base.next = new ListNode(carry);
        return dummyHead.next;
    }
}
