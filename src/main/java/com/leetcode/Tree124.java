package com.leetcode;

public class Tree124 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }
    static int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }

    /**
     * @param root
     * @return 当前树中能获得的最大路径和
     */
    public int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        //获取当前树的最大值
        int curTreeMaxSum = left + right + root.val;
        res = Math.max(curTreeMaxSum, res);
        //返回给父节点当前子树的最大值
        // 只能是 root.left + root 或者 root.right + root 或者 root 的组合
        int outPutMaxSum = Math.max(left, right);
        return outPutMaxSum + root.val;
    }
}
