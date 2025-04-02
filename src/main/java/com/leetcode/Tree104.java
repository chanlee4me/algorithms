package com.leetcode;

public class Tree104 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }
    private static int func(TreeNode root){
        if(root == null) return 0;
        int left = func(root.left);
        int right = func(root.right);
        return Math.max(left, right) + 1;
    }
}
