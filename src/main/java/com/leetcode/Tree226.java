package com.leetcode;

public class Tree226 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }
    private static TreeNode func(TreeNode root){
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        TreeNode left = func(root.left);
        TreeNode right = func(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
