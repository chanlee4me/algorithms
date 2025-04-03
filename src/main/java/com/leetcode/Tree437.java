package com.leetcode;

public class Tree437 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }
    private static int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        res = 0;
        travel(root, targetSum);
        return res;
    }
    public static void dfs(TreeNode root, long sum, int targetSum){
        if(root == null) return;
        sum += root.val;
        if(sum == targetSum) res++;
        dfs(root.left, sum, targetSum);
        dfs(root.right, sum, targetSum);
        sum -= root.val;
    }
    public static void travel(TreeNode root, int targetSum){
        //以每个节点都作为根节点来求 sum
        if(root == null) return;
        dfs(root, 0, targetSum);
        travel(root.left, targetSum);
        travel(root.right, targetSum);
    }

}

