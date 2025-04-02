package com.leetcode;

public class ListNode19 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode ptr){
            this.val = val;
            next = ptr;
        }
    }

    /**
     * 删除链表的倒数第 k 个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pre = dummyHead;
        ListNode fast = pre;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while(fast.next != null){
            pre = pre.next;
            fast = fast.next;
        }
        if(pre != null)
            pre.next = pre.next.next;
        return dummyHead.next;
    }

}
