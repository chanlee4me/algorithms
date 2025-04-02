package com.leetcode;

public class ListNode160 {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    /**
     * 给你两个单链表的头节点 headA 和 headB ，
     * 请你找出并返回两个单链表相交的起始节点。
     * 如果两个链表不存在相交节点，返回 null 。
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null) return null;
        //先获取两个链表的长度
        int lengthA = 0, lengthB = 0;
        ListNode curNodeOfA = headA;
        while(curNodeOfA != null){
            lengthA++;
            curNodeOfA = curNodeOfA.next;
        }
        ListNode curNodeOfB = headB;
        while(curNodeOfB != null){
            lengthB++;
            curNodeOfB = curNodeOfB.next;
        }
        //将指针移到同一起点位置（这里同一起点指到链表末尾长度相同）
        curNodeOfA = headA;
        curNodeOfB = headB;
        if(lengthA > lengthB){
            for (int i = 0; i < lengthA - lengthB; i++) {
                curNodeOfA = curNodeOfA.next;
            }
        }else{
            for (int i = 0; i < lengthB - lengthA; i++) {
                curNodeOfB = curNodeOfB.next;
            }
        }
        //向后移动指针，判断是否相交
        while(curNodeOfA != null && curNodeOfB != null){
            if(curNodeOfA != curNodeOfB){
                curNodeOfA = curNodeOfA.next;
                curNodeOfB = curNodeOfB.next;
                continue;
            }
            return curNodeOfA;
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode cur = headA;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        ListNode headB = new ListNode(-1);
        headB.next = cur;
        ListNode node = getIntersectionNode(headA, headB);
        System.out.println("node.val = " + node.val);
    }
}
