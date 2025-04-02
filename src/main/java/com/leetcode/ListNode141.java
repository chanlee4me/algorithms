package com.leetcode;

public class ListNode141 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        if(head.next == head) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
