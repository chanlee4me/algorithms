package com.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Tree199 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }
    private static List<Integer> func(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        //层次遍历，只添加最右侧的节点
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            TreeNode node = null;
            for (int i = 0; i < size; i++) {
                node = deque.removeFirst();
                if(node.left != null) deque.addLast(node.left);
                if(node.right != null) deque.addLast(node.right);
            }
            res.add(node.val);
        }

        return res;
    }
}
