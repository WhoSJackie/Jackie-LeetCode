package com.wang.learning;

public class No814 {

    public TreeNode pruneTree(TreeNode root) {
        if (root==null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left!=null||root.right!=null) return root;
        return root.val==0?null:root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null,new TreeNode(0,new TreeNode(0),new TreeNode(1)));
        new No814().pruneTree(root);
    }
}
