package com.leetcode;

public class Tree101 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
    }
    private static boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.left == null && root.right != null) return false;
        if(root.left != null && root.right == null) return false;

        return func(root.left, root.right);
    }
    private static boolean func(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null && root2 != null) return false;
        if(root1 != null && root2 == null) return false;

        if(root1.val != root2.val) return false;
        return func(root1.left, root2.right) && func(root1.right, root2.left);
    }
}
