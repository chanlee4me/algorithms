package com.leetcode;

public class Tree98 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }
    public boolean isValidBST(TreeNode root) {
        return func(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private static boolean func(TreeNode root, long min, long max){
        //在向下递归时，要有一个上界 or 下界
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        if(root.left == null && root.right == null) return true;
        if(root.left != null && root.right == null){
            if(root.left.val < root.val) return func(root.left, min, root.val);
        }else if(root.left == null && root.right != null){
            if(root.right.val > root.val) return func(root.right, root.val, max);
        }else{
            if(root.left.val < root.val && root.right.val > root.val){
                return func(root.left, min, root.val) && func(root.right, root.val, max);
            }
        }
        return false;
    }
}
