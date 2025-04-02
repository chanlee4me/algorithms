package com.leetcode;

import com.sun.management.UnixOperatingSystemMXBean;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Tree102 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }
    private static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        //层序遍历
        Deque<TreeNode> queue = new LinkedList<>();

        queue.addLast(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                list.add(node.val);
                if(node.left != null) queue.addLast(node.left);
                if(node.right != null) queue.addLast(node.right);
            }
            res.add(new ArrayList<>(list));
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        List<List<Integer>> res = levelOrder(root);
        System.out.println(res);
    }
}
