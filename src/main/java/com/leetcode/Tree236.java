package com.leetcode;

public class Tree236 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        /**
         * 找最近公共祖先
         * 如果 p or q位于根节点，另一个位于他的子节点，那么 p or q 就是要找的节点
         * 如果 p、q 分别位于 root 的左右节点，那么 root 就是要找的节点
         * 如果 p、q位于 root 的左/右子树，那么向下递归
         */
        if(root == null) return root;
        if(root == p || root == q) return root;
        //下方2 个递归的本质是去找到 p 或者 q，如果只找到其中一个，说明另一个在这个节点的更深处，那么当前节点就一定是最近公共节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);//理解为去左子树中找 p、q
        TreeNode right = lowestCommonAncestor(root.right, p, q);//理解为去右子树中找 p、q
        if(left != null && right != null){
            return root;//p、q 分别位于 root 的左右节点，那么 root 就是要找的节点
        } else if (left == null && right != null) {
            return right;
        } else {
            return left;
        }
    }
}
