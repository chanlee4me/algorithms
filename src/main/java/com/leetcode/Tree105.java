package com.leetcode;

import java.util.Map;

public class Tree105 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * @param preNums  前序数组
     * @param preLeft  前序数组左边界
     * @param preRight 前序数组右边界
     * @param inNums   中序数组
     * @param inLeft   中序数组左边界
     * @param inRight  中序数组右边界
     * @param map      存储每个元素值在中序数组中的索引映射关系
     * @return
     */
    private static TreeNode func(int[] preNums, int preLeft, int preRight, int[] inNums, int inLeft, int inRight, Map<Integer, Integer> map) {
        if (preLeft > preLeft || inLeft > inRight) return null;
        //preLeft就是当前在前序数组中取的那个作为根节点的索引
        int rootVal = preNums[preLeft];
        TreeNode root = new TreeNode(rootVal);
        //获取当前根节点在中序数组中的索引
        int inIndex = map.get(rootVal);

        root.left = func(preNums, preLeft + 1, inIndex - inLeft + preRight, inNums, inLeft, inIndex - 1, map);
        root.right = func(preNums, inIndex - inLeft + preRight + 1, preRight, inNums, inIndex + 1, inRight,  map);
        return root;
    }
}