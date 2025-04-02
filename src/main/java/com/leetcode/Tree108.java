package com.leetcode;

public class Tree108 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }
    private static TreeNode func(int[] nums, int left, int right){
        if(left > right) return null;
        int mid = left + (right - left) / 2;
        int val = nums[mid];
        TreeNode root = new TreeNode(val);
        root.left = func(nums, left, mid - 1);
        root.right = func(nums, mid + 1, right);
        return root;
    }
}
