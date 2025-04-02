package com.leetcode;

public class ListNode234 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * 判断是否是回文链表
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head){
        if(head == null || head.next == null) return true;
        if(head.next.next == null){
            return head.next.val == head.val;
        }
        //找到链表中点（slow 停在中间或前半部分的最后一个节点）
        ListNode pre = null, slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //反转后半段链表
        ListNode head2 = reverseList(slow);
        ListNode curNode = head2;
        //判断是否每个节点值都相等
        while(curNode != null){
            if(curNode.val != head.val) return false;
            curNode = curNode.next;
            head = head.next;
        }
        //TODO:将链表翻转回去

        return true;

    }
    /**
     * 翻转链表
     * @param head 头节点
     * @return
     */
    private static ListNode reverseList(ListNode head){
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
