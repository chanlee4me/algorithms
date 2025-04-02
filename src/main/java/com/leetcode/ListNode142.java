package com.leetcode;

public class ListNode142 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * 环形链表II
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        //快慢指针找到相遇点
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(slow != fast) return null;
        //由公式得：环入口距头节点长度 x = (n - 1)(a + b) + b
        //其中 b 是相遇点到环入口的距离
        //两个指针分别从相遇点、链表头节点出发，首次相遇的位置就是环入口
        ListNode cur = head;
        while(cur != slow){
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }
}
