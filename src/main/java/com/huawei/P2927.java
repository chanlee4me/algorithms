package com.huawei;
import java.util.*;

public class P2927 {
    static int res = 0;
    static class TreeNode{
        int flag; //0：未被覆盖/建设  1：被覆盖 2：建设
        TreeNode left;
        TreeNode right;
        TreeNode(){
            flag = 0;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {
        res = 0;

        // 接受输入
        Scanner in = new Scanner(System.in);
        String[] nums = in.nextLine().split(" ");

        // build tree
        TreeNode root = buildTree(nums);

        // core
        travel(root);

        //单独处理根节点
        if(root.flag == 1 || root.flag == 2){
            System.out.println(res);
            return;
        }
        int l = 1; //左孩子节点状态，默认为 1（把空节点也当做被覆盖）
        int r = 1;
        if(root.left != null)
            l = root.left.flag;
        if(root.right != null)
            r = root.right.flag;
        // 有孩子未被覆盖，需要在当前节点建站
        if(l == 0 || r == 0){
            res++;
        }
        // 两个孩子都没建站，需要在当前节点建站
        else if(l != 2 && r != 2){
            res++;
        }
        System.out.println(res);
    }
    public static TreeNode buildTree(String[] nums){
        if(nums.length == 0 || nums[0].equals("N")) return null;
        Deque<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode();
        queue.offer(root);

        for (int i = 1; i < nums.length; i++) {
            TreeNode curRoot = queue.poll();
            if(!nums[i].equals("N")){
                TreeNode left = new TreeNode();
                curRoot.left = left;
                queue.add(left);
            }
            i++;
            if(i >= nums.length) break;
            if(!nums[i].equals("N")){
                TreeNode right = new TreeNode();
                curRoot.right = right;
                queue.add(right);
            }
        }
        return root;
    }
    public static void travel(TreeNode root){
        if(root == null) return;
        // 如果当前节点是叶子节点，那么不建设
        if(root.left == null && root.right == null) return;

        // 后序遍历
        travel(root.left);
        travel(root.right);

        int l = 1; //左孩子节点状态，默认为 1（把空节点也当做被覆盖）
        int r = 1;
        if(root.left != null)
            l = root.left.flag;
        if(root.right != null)
            r = root.right.flag;

        // 有孩子未被覆盖，需要在当前节点建站
        if(l == 0 || r == 0){
            root.flag = 2;
            res++;
        }
        // 有孩子建站，当前节点被覆盖
        else if(l == 2 || r == 2){
            root.flag = 1;
        }
    }
}

