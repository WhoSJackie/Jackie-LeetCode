package com.wang.java_Learning.treevisit;

public class TreeNode {

    Integer value;

    TreeNode left;

    TreeNode right;

    public TreeNode(Integer value){
        this.value = value;
    }

    public TreeNode(Integer value,TreeNode left,TreeNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

}
