package com.leetcode;

public class Tree114 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }

    /**
     * 将二叉树展开为链表，左孩子为空，右孩子指向下一个节点
     * @param root
     */
    private static void func(TreeNode root){
        if(root == null) return;//根节点为空直接返回
        else{
            if(root.left == null){//如果left为空，那么只对root的右子树做递归处理即可
                func(root.right);
            }else{//left不为空，把左子树查到右孩子上，并把右子树插到左子树的最右节点的右孩子
                //找到当前左子树的最右节点
                TreeNode node = root.left;
                while(node.right != null){
                    node = node.right;
                }
                //把右子树插入到 node 的右孩子位置
                node.right = root.right;
                //把左子树插入到右孩子位置
                root.right = root.left;
                root.left = null;
                func(root.right);//对更新后的右孩子做上述的相同操作
            }
        }
    }
}
