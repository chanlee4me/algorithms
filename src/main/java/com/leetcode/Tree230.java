package com.leetcode;

import java.util.ArrayList;
import java.util.List;
public class Tree230 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>(); // 在方法内部初始化
        inorder(root, list); // 传递 list，方法内部会填充它
        return list.get(k - 1);
    }

    private static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val); // 修改的是外部的 list
        inorder(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 1;
        System.out.println(kthSmallest(root, k)); // 输出 1
    }
}