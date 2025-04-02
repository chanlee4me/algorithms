package com.Prac;

public class Prac{
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    public static boolean func(Node head){
        if(head == null || head.next == null) return false;
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            if(slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        System.out.println(func(root));
        root.next.next.next = root;
        System.out.println(func(root));
    }
}
