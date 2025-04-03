package com.leetcode;

public class Tree543 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }
    static int res = 0;
    private static int func(TreeNode root){
        res = 0;
        maxHeight(root);
        return res;
    }
    private static int maxHeight(TreeNode root){
        if(root == null) return 0;
        int left = maxHeight(root.left);
        int right = maxHeight(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}
